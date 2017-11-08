package aliupload;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.media.MediaConfiguration;
import com.alibaba.media.MediaFile;
import com.alibaba.media.Result;
import com.alibaba.media.client.MediaClient;
import com.alibaba.media.client.impl.DefaultMediaClient;
import com.alibaba.media.upload.*;
import com.alibaba.media.upload.impl.DefaultUploadClient;
import com.alibaba.media.upload.impl.DefaultUploadTokenClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhang.lao.build.kit.Prop;
import zhang.lao.build.kit.PropKit;
import zhang.lao.build.tool.FileTool;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyzhou.zhy 2015.03.05
 *         这个Demo展示了 UploadClient 的接口使用方法
 *         Media SDK 为这个接口提供了一个默认实现 DefaultUploadClient
 *         <p/>
 *         这个Demo展示了 UploadTokenClient 的接口使用方法
 *         Media SDK 为这个接口提供了一个默认实现 DefaultUploadTokenClient
 */
public class MediaUploadClient {
    private static  final Logger logger = LoggerFactory.getLogger(MediaUploadClient.class);
	/**
	 * 图片文件阿里存储地址
	 */
    public final static String namespace ;
	/**
	 * 非图片文件阿里存储地址
	 */
	public final static String IMG_DIR;
	
	public final static String FILE_DIR;
	

    private static final MediaClient client;
    private static final MediaConfiguration configuration = new MediaConfiguration();
    static {
        /**
         * 初始化 MediaConfiguration
         * 配置图片服务的AK:           AccessKey、AccessKeySecret
         * 配置图片服务的namespace:
         */
        Prop use = PropKit.use("sys.properties");
        namespace= use.get("aliyun.namespace");
        IMG_DIR="/"+namespace+"/img";
        FILE_DIR="/"+namespace+"/file";
        configuration.setAk(use.get("aliyun.ak"));
        configuration.setSk(use.get("aliyun.sk"));
        configuration.setNamespace(namespace);
        /**
         * 初始化 UploadClient
         */
        client = new DefaultMediaClient(configuration) {
            @Override
            protected UploadPolicy getDefaultUploadPolicy() {
                UploadPolicy uploadPolicy = super.getDefaultUploadPolicy();
                uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
                return uploadPolicy;
            }
        };
    }

    /**
     * 用户直接上传多媒体文件
     * @param file 文件
     */
    public static  UploadResponse  uploadImg( File file,String fileName) {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);
        UploadRequest uploadRequest = new UploadRequest(uploadPolicy);
        uploadRequest.setFile(file);// 文件
        uploadRequest.setDir(IMG_DIR+"/"+FileTool.getExtention(fileName).replace(".", ""));// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
        	return result.getData();
        }else{
        	return null;
        }
    }

    /**
     * 用户直接上传多媒体文件
     * @param file 文件
     */
    public static UploadResponse uploadFile( File file,String fileName) {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);
        UploadRequest uploadRequest = new UploadRequest(uploadPolicy);
        uploadRequest.setFile(file);// 文件
        uploadRequest.setDir(FILE_DIR+"/"+ FileTool.getExtention(fileName).replace(".", ""));// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
            return result.getData();
        }else{
        	return null;
        }
    }



    /**
     * 用户直接上传多媒体文件
     */
    public static UploadResponse uploadImg(InputStream inputStream,String fileName,Long inputLength)  throws FileNotFoundException {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);
        UploadRequest uploadRequest = new UploadRequest(uploadPolicy);
        uploadRequest.setInputStream(inputStream, inputLength);// 文件
        uploadRequest.setDir(IMG_DIR+"/"+FileTool.getExtention(fileName).replace(".", ""));// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
            return result.getData();
        }else{
            return null;
        }
    }
    /**
     * 用户直接上传多媒体文件
     */
    public static UploadResponse uploadFile(InputStream inputStream,String fileName,Long inputLength)  throws FileNotFoundException {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);
        UploadRequest uploadRequest = new UploadRequest(uploadPolicy);
        uploadRequest.setInputStream(inputStream, inputLength);// 文件
        uploadRequest.setDir(FILE_DIR+"/"+FileTool.getExtention(fileName).replace(".", ""));// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
            return result.getData();
        }else{
           throw  new FileNotFoundException(result.getMessage());
        }
    }
    /**
     * 用户直接上传多媒体文件
     */
    public static UploadResponse uploadFileBefroeDel(InputStream inputStream,String fileName,Long inputLength,String dir)  throws FileNotFoundException {
        Result<Void> deleteResult =  client.deleteFile(FILE_DIR+"/"+dir,fileName);
        if (deleteResult.isSuccess()) { //删除成功
            System.out.println("Delete File Success");
        } else {
            System.out.println(deleteResult.toString());
        }

        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);
        UploadRequest uploadRequest = new UploadRequest(uploadPolicy);
        uploadRequest.setInputStream(inputStream, inputLength);// 文件
        uploadRequest.setDir(FILE_DIR+"/"+dir);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
            logger.info(result.getData().getUrl());
            return result.getData();
        }else{
            throw  new FileNotFoundException(result.getMessage());
        }
    }
    public static UploadResponse upload(String dir,InputStream inputStream,String fileName,Long inputLength)  throws FileNotFoundException {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);
        UploadRequest uploadRequest = new UploadRequest(uploadPolicy);
        uploadRequest.setInputStream(inputStream, inputLength);// 文件
        uploadRequest.setDir(dir);// 云存储路径
        uploadRequest.setName(fileName);// 文件名
        Result<UploadResponse> result = client.upload(uploadRequest);
        if(result.isSuccess()){
            return result.getData();
        }else{
            return null;
        }
    }


    public static  String uploadBuyUrl(String url ){
            URL uri = null;
            InputStream is = null;
            try {
                uri = new URL(url);
                // 打开连接
                URLConnection con = uri.openConnection();
                //设置请求超时为5s
                con.setConnectTimeout(5 * 1000);
                // 输入流
                is = con.getInputStream();
                String ext = FileTool.getExtention(url);
                String ufn =System.nanoTime()+ ext;
                UploadResponse u = MediaUploadClient.uploadImg(is, ufn, con.getContentLengthLong());
                if (u != null)
                    return u.getUrl();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
//		MediaUploadClient.
        return PropKit.use("sys.properties").get("app.defaultHeadimage");
    }

    /**
     * 实例一
     * 直接上传多媒体文件,简单接口
     */
    public static void uploadSimple() {
        File file = new File("D:/zxing.png");
        /**
         * 开发者上传接口示例
         * MediaFile upload(String dir, String name, File file) throws MediaException;
         */
        Result<MediaFile> result = client.upload("测试", "测试", file);
        if (result.isSuccess()) {
            // 调用接口成功,打印出上传接口的返回信息
            System.out.println(JSON.toJSONString(result.getData()));
        } else {
            // 调用接口失败,输出错误信息便于排查问题
            System.out.println(JSON.toJSONString(result));
        }

    }

}
