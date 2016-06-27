/*
 * Copyright (c) 2016 太阳花互动科技. All Rights Reserved.
 */
package zhang.lao.console.controller.common.model;

public class UploadAliModel {

	private String url;
	
	private String md5;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public UploadAliModel(String url, String md5) {
		super();
		this.url = url;
		this.md5 = md5;
	}

	public UploadAliModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
