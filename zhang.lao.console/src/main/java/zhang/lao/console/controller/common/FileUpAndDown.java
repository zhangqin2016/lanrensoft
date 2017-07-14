package zhang.lao.console.controller.common;

import com.baidu.BaiduueUploadResp;
import zhang.lao.build.kit.LogKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFile;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultEnum;
import zhang.lao.pojo.console.resp.HttpResultUtil;
import zhang.lao.pojo.upload.UploadResp;
import zhang.lao.service.console.UploadService;

import zhang.lao.build.tool.FileTool;
import zhang.lao.build.tool.date.DateStyle;
import zhang.lao.build.tool.date.DateUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
	public @ResponseBody HttpResult upload(HttpServletRequest request) throws IOException {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			//判断 request 是否有文件上传,即多部分请求
			if(multipartResolver.isMultipart(request)) {
				//转换成多部分request
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> fileNames = multipartRequest.getFileNames();
				String fileName = fileNames.next();
				MultipartFile uploadFile = multipartRequest.getFile(fileName);
				if (uploadFile == null) {
					return HttpResultUtil.buildError(HttpResultEnum.UPLOADERROR);
				} else {
					String serverPath=File.separator+"upload"+File.separator+DateUtil.DateToString(new Date(), DateStyle.YYYYMMDD);
					String ext = FileTool.getExtention(uploadFile.getOriginalFilename());
					String name=System.nanoTime()+ext;
					 UploadResp uploadResp = uploadService.uploadLocal(uploadFile.getInputStream(), serverPath, name);
				return HttpResultUtil.buildSuccess(uploadResp);
				}
			}
		return HttpResultUtil.buildError(HttpResultEnum.UPLOADERROR);
	}

	@RequestMapping("/file/upload/ali")
	public @ResponseBody
	HttpResult uploadAli(HttpServletRequest request) throws IOException {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			//判断 request 是否有文件上传,即多部分请求
			if(multipartResolver.isMultipart(request)) {
				//转换成多部分request
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> fileNames = multipartRequest.getFileNames();
				String fileName = fileNames.next();
				MultipartFile uploadFile = multipartRequest.getFile(fileName);
				if (uploadFile == null) {
					return HttpResultUtil.buildError(HttpResultEnum.UPLOADERROR);
				} else {
					SysFile sysFile = uploadService.uploadToAli(uploadFile);
					return HttpResultUtil.buildSuccess(sysFile);
				}
			}
		return HttpResultUtil.buildError(HttpResultEnum.UPLOADERROR);
	}

	@RequestMapping("/file/upload/ali/ue")
	public @ResponseBody
	BaiduueUploadResp uploadAliUe(HttpServletRequest request, String action) throws IOException {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			//判断 request 是否有文件上传,即多部分请求
			if(multipartResolver.isMultipart(request)) {
				//转换成多部分request
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> fileNames = multipartRequest.getFileNames();
				String fileName = fileNames.next();
				MultipartFile uploadFile = multipartRequest.getFile(fileName);
				if (uploadFile == null) {
					BaiduueUploadResp uploadResp = new BaiduueUploadResp();
					uploadResp.setState("ERROR");
					return uploadResp;
				} else {
					SysFile sysFile = uploadService.uploadToAli(uploadFile);
					BaiduueUploadResp uploadResp = new BaiduueUploadResp();
					uploadResp.setState("SUCCESS");
					uploadResp.setOriginal(uploadFile.getOriginalFilename());
					uploadResp.setSize(sysFile.getFileSize()+"");
					uploadResp.setTitle(sysFile.getFileName());
					uploadResp.setType(sysFile.getFileType());
					uploadResp.setUrl(sysFile.getFileUrl());
					return uploadResp;
				}
			}else{
				BaiduueUploadResp uploadResp = new BaiduueUploadResp();
				uploadResp.setState("ERROR");
				return uploadResp;
			}
	}
}
