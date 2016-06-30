package zhang.lao.console.common;

import com.alibaba.media.upload.UploadResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import zhang.lao.console.service.UploadService;
import zhang.lao.pojo.resault.CommonResp;
import zhang.lao.pojo.upload.UploadResp;
import zhang.lao.tool.FileTool;
import zhang.lao.tool.date.DateStyle;
import zhang.lao.tool.date.DateUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Iterator;

@Controller
public class FileUpAndDown{

	@Resource
	private UploadService uploadService;
	/**
	 * 上传至阿里云
	 */
	@RequestMapping("/file/upload")
	public @ResponseBody String upload(HttpServletRequest request){
		try{
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			//判断 request 是否有文件上传,即多部分请求
			if(multipartResolver.isMultipart(request)) {
				//转换成多部分request
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> fileNames = multipartRequest.getFileNames();
				String fileName = fileNames.next();
				MultipartFile uploadFile = multipartRequest.getFile(fileName);
				if (uploadFile == null) {
					return CommonResp.getJson(CommonResp.getError());
				} else {
					String serverPath=File.separator+"upload"+DateUtil.DateToString(new Date(), DateStyle.YYYYMMDD);
					String ext = FileTool.getExtention(uploadFile.getOriginalFilename());
					String name=System.nanoTime()+ext;
					UploadResp uploadResp = uploadService.uploadLocal(uploadFile.getInputStream(), serverPath, name);
					return CommonResp.getJson(CommonResp.getSuccess(uploadResp));
				}
			}
			return CommonResp.getJson(CommonResp.getError());
		}catch(Exception e){
			e.printStackTrace();
			return CommonResp.getJson(CommonResp.getError());
		}
	}

	/**
	 * 上传至阿里云
	 */
	@RequestMapping("/file/upload_ali")
	public @ResponseBody String upload_ali(HttpServletRequest request){
		try{
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			//判断 request 是否有文件上传,即多部分请求
			if(multipartResolver.isMultipart(request)) {
				//转换成多部分request
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> fileNames = multipartRequest.getFileNames();
				String fileName = fileNames.next();
				MultipartFile uploadFile = multipartRequest.getFile(fileName);
				if (uploadFile == null) {
					return CommonResp.getJson(CommonResp.getError());
				} else {
					String ext = FileTool.getExtention(uploadFile.getOriginalFilename());
						return CommonResp.getJson(CommonResp.getError());
				}
			}
			return CommonResp.getJson(CommonResp.getError());
	}catch(Exception e){
		e.printStackTrace();
			return CommonResp.getJson(CommonResp.getError());
	}
	}
	
	/**
	 * 上传至阿里云
	 */
	@RequestMapping("/file/upload_ali_md5")
	public @ResponseBody String upload_ali_md5(HttpServletRequest request){
		try{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(multipartResolver.isMultipart(request)) {
			//转换成多部分request
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> fileNames = multipartRequest.getFileNames();
			String fileName = fileNames.next();
			MultipartFile uploadFile = multipartRequest.getFile(fileName);

			if (uploadFile == null) {
				return CommonResp.getJson(CommonResp.getError());
			} else {
				Object userId = request.getSession().getAttribute("user_id");
				long size = uploadFile.getSize();
				UploadResponse result = null;
		/*	if(size>100000){
				result =MediaUploadClient.blockUpload(userId==null?UUIDTool.getUUID():userId.toString(),file, uploadFile.getOriginalFileName());
			}else{*/
				//}
				if (result != null) {
					return CommonResp.getJson(CommonResp.getSuccess(null));
				} else {
					return CommonResp.getJson(CommonResp.getError());
				}
			}
		}
			return CommonResp.getJson(CommonResp.getError());
		}catch(Exception e){
			e.printStackTrace();
			return CommonResp.getJson(CommonResp.getError());
		}
	}
}
