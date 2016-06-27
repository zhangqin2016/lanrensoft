package zhang.lao.console.model.login;

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
	private static final long serialVersionUID = -2813660448202866915L;
/**
 * 1是系统账户
 */
public static final String loginTypeSys="1";
/**
 * 应用账户
 */
public static final String loginTypeApp="2";
	
	private Integer user_id;
	private String  user_name;
	/**
	 * 用户类型 1企业 2个人3应用
	 */
	private Integer user_type;
	private Integer is_auth;
	private String email;
	private String phone;
	private Integer verify_email;
	private String user_pic;
	private Integer status;
	private Integer da_id;
	private Integer create_user_id;
	private Date create_time;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_type() {
		return user_type;
	}
	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIs_auth() {
		return is_auth;
	}
	public void setIs_auth(Integer is_auth) {
		this.is_auth = is_auth;
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
	public Integer getVerify_email() {
		return verify_email;
	}
	public void setVerify_email(Integer verify_email) {
		this.verify_email = verify_email;
	}
	public String getUser_pic() {
		return user_pic;
	}
	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}
	public Integer getDa_id() {
		return da_id;
	}
	public void setDa_id(Integer da_id) {
		this.da_id = da_id;
	}
	public Integer getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(Integer create_user_id) {
		this.create_user_id = create_user_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
}
