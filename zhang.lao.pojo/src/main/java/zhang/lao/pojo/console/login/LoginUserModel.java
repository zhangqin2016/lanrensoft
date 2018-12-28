package zhang.lao.pojo.console.login;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * title:用户登录类
 * </p>
 * <p>
 * description:
 * </p>
 * 
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月18日
 */
public class LoginUserModel implements Serializable{
	/**
	 * 
	 */
	private static final Long serialVersionUID = -2813660448202866915L;
	/**
	 * 1是系统账户
	 */
	public static final String loginTypeSys="1";

	/**
	 * 普通账户
	 */
	public static final String loginTypeApp="2";
	
	private String user_id;
	private Short user_type;
	private String email;
	private String phone;
	private String user_pic;
	private String userNickName;
	private String userAccount;
	private Integer status;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	private Date create_time;

	public short getUser_type() {
		return user_type;
	}

	public void setUser_type(short user_type) {
		this.user_type = user_type;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_pic() {
		return user_pic;
	}
	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public static String getLoginTypeSys() {
		return loginTypeSys;
	}

	public static String getLoginTypeApp() {
		return loginTypeApp;
	}
}
