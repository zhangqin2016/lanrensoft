package zhang.lao.pojo.req.api.token;

import org.hibernate.validator.constraints.NotBlank;
import zhang.lao.pojo.req.api.ApiReqBody;

/**
 * 
* @ClassName: TokenReq 
* @Description: token请求
* @author zhangqin
* @date 2016年4月15日 下午1:58:49 
*
 */
public class TokenReq extends ApiReqBody {

	/**
	 * appid
	 */
	@NotBlank
	private String appid;
	
	/**
	 * 时间秒数
	 */
	@NotBlank
	private String t;
	
	/**
	 * 签名串
	 */
	@NotBlank
	private String h;
	
	/**
	 * openid对同一台设备保持不变
	 */
	@NotBlank
	private String openid;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
