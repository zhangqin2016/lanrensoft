package zhang.lao.console.controller.common;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.media.MediaConfiguration;
import com.alibaba.media.MediaException;
import com.alibaba.media.upload.UploadPolicy;
import com.alibaba.media.upload.UploadTokenClient;
import com.alibaba.media.upload.impl.DefaultUploadTokenClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import zhang.lao.build.kit.ehcache.CacheKit;
import zhang.lao.build.mybatis.jdbc.auto.dao.SysFileMapper;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFile;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFileExample;
import zhang.lao.build.tool.FileTool;
import zhang.lao.build.tool.ListUtils;
import zhang.lao.build.tool.SysProperties;
import zhang.lao.build.tool.date.DateStyle;
import zhang.lao.build.tool.date.DateUtil;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultEnum;
import zhang.lao.pojo.console.resp.HttpResultUtil;
import zhang.lao.service.console.UploadService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

@Controller
public class FileUpAndDown {

	@Resource
	private UploadService uploadService;
	@Resource
	private SysFileMapper sysFileMapper;
	/**
	 * 上传至阿里云
	 */
	@RequestMapping("/file/upload")
	public @ResponseBody
    HttpResult upload(HttpServletRequest request) throws IOException {
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
					String serverPath=File.separator+"upload"+File.separator+ DateUtil.DateToString(new Date(), DateStyle.YYYYMMDD);
					String ext = FileTool.getExtention(uploadFile.getOriginalFilename());
					String name=System.nanoTime()+ext;
					 SysFile sysFile = uploadService.uploadToDb(uploadFile.getInputStream(), serverPath, name);
				return HttpResultUtil.buildSuccess(sysFile);
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

	@RequestMapping("/console/file/exist/{md5}")
	public @ResponseBody
    HttpResult hasFile(@PathVariable String md5){
		SysFileExample sysFileExample = new SysFileExample();
		sysFileExample.createCriteria().andFileMd5EqualTo(md5);
		SysFile first = ListUtils.getFirst(sysFileMapper.selectByExample(sysFileExample));
		if(first!=null){
			return HttpResultUtil.buildSuccess(first);
		}else{
			return HttpResultUtil.buildError(HttpResultEnum.FAIL);
		}
	}


	@RequestMapping(value = "/console/file/ali/token",method = {RequestMethod.POST})
	public @ResponseBody HttpResult getAliToken(){
		JSONObject jsonObject = new JSONObject();
		if(CacheKit.get("aliToken","aliToken")!=null){
			jsonObject.put( "token", CacheKit.get("aliToken","aliToken") );
		}else {
			try {
				//1. 定义全局配置信息
				MediaConfiguration configuration = new MediaConfiguration();
				configuration.setAk(SysProperties.aliyunAk); //用户控制台的AccessKey
				configuration.setSk(SysProperties.aliyunSk); //用户控制台的AccessSecret
				configuration.setNamespace(SysProperties.aliyunNamespace); //用户的空间名namespace

				// 2. 获取凭证Client
				UploadTokenClient tokenClient = new DefaultUploadTokenClient(configuration);

				// 3. 定义上传策略
				UploadPolicy uploadPolicy = new UploadPolicy();
				uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE); //INSERT_ONLY_NONE=0表示可覆盖上传，INSERT_ONLY=1表示不可覆盖
				uploadPolicy.setExpiration(-1); //token过期时间，单位毫秒。-1表示永不过期。
				// 4. 获取上传Token
				String token = tokenClient.getUploadToken(uploadPolicy);
				CacheKit.put("aliToken", "aliToken", token);
				// 5. 输出
				jsonObject.put("token", token);

			} catch (MediaException e) {
				return HttpResultUtil.buildError(HttpResultEnum.FAIL);
			}
		}
		return HttpResultUtil.buildSuccess(jsonObject);
	}
}
