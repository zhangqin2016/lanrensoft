package zhang.lao.pojo.resp;

/**
 * <p>
 * title:http请求结果对象
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
public class HttpResult {

	/**
	 *参数不完整
	 */
	public static final String code_param_error="0";
	
	/**
	 * 没有找到相关信息
	 */
	public static final String code_nofind_error="1";
	/**
	 * 失败的状态码
	 */
	public static final String status_error="0";
	/**
	 * 成功的状态码
	 */
	public static final String status_sucess="1";
	/**
	 * 没有权限的状态码
	 */
	public static final String status_no_permission="-1";
	
	/**
	 * 失败的状态码
	 */
	public static final String status_error_message="请求失败";
	/**
	 * 失败的状态码
	 */
	public static final String code_error_param_message="请求参数有误";
	/**
	 * 成功的状态码
	 */
	public static final String status_sucess_message="请求成功";
	/**
	 * 没有权限的状态码
	 */
	public static final String status_no_permission_message="没有该请求的权限";
	
	/**
	 * 没有找到相关信息
	 */
	public static final String code_nodata_message="没有找到相关信息";
	/**
	 * 状态码
	 */
	private String http_status;
	/**
	 * 返回的数据
	 */
	private Object data;
	/**
	 * 返回的消息
	 */
	private String message;
	/**
	 * 返回的具体的错误码
	 */
	private String code;
	public String getHttp_status() {
		return http_status;
	}
	public void setHttp_status(String http_status) {
		this.http_status = http_status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 
	 * @param http_status
	 * @param message
	 */
	public HttpResult(String http_status, String message) {
		super();
		this.http_status = http_status;
		this.message = message;
	}
	/**
	 * 
	 * @param http_status
	 * @param data
	 * @param message
	 */
	public HttpResult(String http_status, Object data, String message) {
		super();
		this.http_status = http_status;
		this.data = data;
		this.message = message;
	}
	/**
	 * 
	 * @param http_status
	 * @param message
	 * @param code
	 */
	public HttpResult(String http_status, String message, String code) {
		super();
		this.http_status = http_status;
		this.message = message;
		this.code = code;
	}
	
	public HttpResult() {
		super();
	}

}
