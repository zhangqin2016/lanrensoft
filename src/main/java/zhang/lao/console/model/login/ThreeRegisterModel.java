package zhang.lao.console.model.login;

import java.io.Serializable;

public class ThreeRegisterModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String driveToken;
	private String client;
	private String userNickName;
	private String userHeadImage;
	private String bindType;
	private String keyId;
	public String getDriveToken() {
		return driveToken;
	}
	public void setDriveToken(String driveToken) {
		this.driveToken = driveToken;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserHeadImage() {
		return userHeadImage;
	}
	public void setUserHeadImage(String userHeadImage) {
		this.userHeadImage = userHeadImage;
	}
	public String getBindType() {
		return bindType;
	}
	public void setBindType(String bindType) {
		this.bindType = bindType;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	
	
}
