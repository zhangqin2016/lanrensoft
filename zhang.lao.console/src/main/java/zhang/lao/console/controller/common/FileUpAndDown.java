package zhang.lao.console.controller.common;


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
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

	
	@RequestMapping("/file/upload/ckeditor")
	public void uploadCkeditor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)) {
			//转换成多部分request
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> fileNames = multipartRequest.getFileNames();
			String fileName = fileNames.next();
			MultipartFile uploadFile = multipartRequest.getFile(fileName);
			PrintWriter out =  response.getWriter();
			// CKEditor提交的很重要的一个参数    
			String callback = request.getParameter("CKEditorFuncNum");
			String expandedName = "";  //文件扩展名    
			String uploadContentType = uploadFile.getContentType();
			if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {
				//IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg    
				expandedName = ".jpg";
			}else if(uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")){
				//IE6上传的png图片的headimageContentType是"image/x-png"    
				expandedName = ".png";
			}else if(uploadContentType.equals("image/gif")){
				expandedName = ".gif";
			}else if(uploadContentType.equals("image/bmp")){
				expandedName = ".bmp";
			}else{
				out.println("<script type=\"text/javascript\">");
				out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
				out.println("</script>");
			}
			if(request.getContentLength() > 1024*1024){
				out.println("<script type=\"text/javascript\">");
				out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",''," + "'文件大小不得大于600k');");
				out.println("</script>");
			}

			SysFile sysFile = uploadService.uploadToAli(uploadFile);
			// 返回"图像"选项卡并显示图片    
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + "" + sysFile.getFileUrl() + "','')");
			out.println("</script>");
		}
	}
}
