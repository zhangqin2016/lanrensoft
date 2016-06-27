/*
 * Copyright (c) 2016 太阳花互动科技. All Rights Reserved.
 */
package zhang.lao.console.service;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import zhang.lao.console.model.GoodsJsonImage;
import zhang.lao.mybatis.auto.dao.GoodsInfoMapper;
import zhang.lao.mybatis.auto.model.GoodsInfo;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 网络抓取数据服务类
 * @author zhangq
 *
 *代码虐我千百遍，我待代码如初恋。
 */
public class WebDataCrawlingService {
	private static final String BASE_URL="http://item.taobao.com/item.htm?id=";

	@Resource
	private GoodsInfoMapper goodsInfoMapper;
	/**
	 * 商品列表url
	 * @return
	 */
	public String  getUrl(String id){
		return BASE_URL+id;
	}


	/**
	 * 得到html内容
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public Document getHtmlBody(String url) throws Exception {
		return  Jsoup.connect(url).timeout(60000).get();
	}
	
	public void ri(GoodsInfo goodsInfo){
		GoodsJsonImage goodsJsonImage = JSON.parseObject(goodsInfo.getResPic(), GoodsJsonImage.class);
		String pic = goodsJsonImage.getResPic();
		if(StringUtils.isNotBlank(pic)){
			try {
				goodsJsonImage.setResPic(getAliYunImgSrc(pic));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<String> images = goodsJsonImage.getImages();
		List<String> newImages = Lists.newArrayList();
		if(images!=null && images.size()!=0){
			for (String string : images) {
				try {
					newImages.add(getAliYunImgSrc(string));
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}
			}
			goodsJsonImage.setImages(newImages);
		}
		goodsInfo.setResPic(JSON.toJSONString(goodsJsonImage));
		goodsInfoMapper.updateByPrimaryKey(goodsInfo);
		
	}

	public void updateGoodsPic(GoodsInfo goodsInfo){
		try {
			String id = goodsInfo.getItemId();
			Document document = getHtmlBody(getUrl(id));
			Elements elements = document.select("#J_UlThumb");
			Element li =elements.get(0);
			Elements elementsImgs = li.select("img");
			GoodsInfo goodsInfoQuery = new GoodsInfo();
			goodsInfoQuery.setItemId(id);
					GoodsJsonImage goodsJsonImage = new GoodsJsonImage();
					List<String> listImage = Lists.newArrayList();
					for (int i = 0; i < elementsImgs.size(); i++) {
						Element element = elementsImgs.get(i);
						String url= element.attr("src");
						url= url.startsWith("http://")?url:"http:"+url;
						url=url.replace("_60x60q90.jpg", "");
						if(i==0){
							goodsJsonImage.setResPic(url);
						}else{
							listImage.add(url);
						}
					}
					goodsJsonImage.setImages(listImage);
					goodsInfo.setResPic(JSON.toJSONString(goodsJsonImage));
			goodsInfoMapper.updateByPrimaryKey(goodsInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将友阿图片链接转换成依恋阿里云链接
	 * @param src
	 * @return
	 * @throws java.io.IOException
	 */
	public static String getAliYunImgSrc(String src) throws IOException{
		HttpURLConnection conn=null;
		InputStream inputStream=null;
		try {
			URL url2=new URL(src);
			conn = (HttpURLConnection)url2.openConnection();  
			conn.setRequestMethod("GET");  
			conn.setConnectTimeout(5 * 1000); 
			inputStream = conn.getInputStream();
		/*	UploadResponse result = MediaUploadClient.uploadImg(inputStream,System.nanoTime()+FileTool.getExtention(src),conn.getContentLengthLong());
			if(result!=null){
				return result.getUrl();
			}else{
				throw new IOException("找不到");
			}*/
			return "";
		} finally{
			try {
				if(inputStream!=null){
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}  


		}
	}

	public static void main(String[] args) {

	}

}
