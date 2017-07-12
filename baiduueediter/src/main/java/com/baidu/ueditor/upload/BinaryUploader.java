package com.baidu.ueditor.upload;

import aliupload.MediaUploadClient;
import com.alibaba.media.upload.UploadResponse;
import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.YhyUeEdit;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.tools.Tool;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class BinaryUploader {
	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		 FileItemStream fileStream = null;
		boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());

		if ( isAjaxUpload ) {
			upload.setHeaderEncoding( "UTF-8" );
		}

		try {
			FileItemIterator iterator = upload.getItemIterator(request);

			while (iterator.hasNext()) {
				fileStream = iterator.next();

				if (!fileStream.isFormField())
					break;
				fileStream = null;
			}

			if (fileStream == null) {
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}

			String savePath = (String) conf.get("savePath");
			String originFileName = fileStream.getName();
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());
			savePath = savePath + suffix;

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			savePath = PathFormat.parse(savePath, originFileName);

			String physicalPath = (String) conf.get("rootPath") + savePath;

			InputStream is = fileStream.openStream();
			YhyUeEdit y = StorageManager.saveFileByInputStreamYhyUeEdit(is,
					physicalPath, maxSize);
			is.close();
			State storageState = y.getState();
			if (storageState.isSuccess()) {
				String ufn = System.nanoTime()+suffix;
				UploadResponse uploadResponse = MediaUploadClient.uploadImg(y.getFile(), ufn);
				if(uploadResponse!=null){
					storageState.putInfo("url", uploadResponse.getUrl());
					storageState.putInfo("type", suffix);
					storageState.putInfo("original", originFileName + suffix);
				}else{
					return new BaseState(false, AppInfo.IO_ERROR) ;
				}

			}

			return storageState;
		} catch (FileUploadException e) {
			return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR) ;
			/*CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			//判断 request 是否有文件上传,即多部分请求
			if(multipartResolver.isMultipart(request)) {
				//转换成多部分request
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> fileNames = multipartRequest.getFileNames();
				String fileName = fileNames.next();
				MultipartFile uploadFile = multipartRequest.getFile(fileName);
				if (uploadFile == null) {
					return new BaseState(false, AppInfo.IO_ERROR);
				} else {
					State state = new BaseState(true);
					try {
						SysFile sysFile = uploadService.uploadToAli(uploadFile);
						state.putInfo( "size", sysFile.getFileSize());
						state.putInfo( "title", sysFile.getFileName() );
						state.putInfo("url", sysFile.getFileUrl());
						state.putInfo("type", sysFile.getFileType());
						state.putInfo("original", sysFile.getFileName());
						return state;
					} catch (IOException e) {
					LogKit.error(e.getMessage(),e);
						return new BaseState(false, AppInfo.IO_ERROR);
					}

				}
			}

		return new BaseState(false, AppInfo.IO_ERROR);*/
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
	private static File getTmpFile() {
		File tmpDir = FileUtils.getTempDirectory();
		String tmpFileName = (Math.random() * 10000 + "").replace(".", "");
		return new File(tmpDir, tmpFileName);
	}

}
