package zhang.lao.pojo.api.req;

import org.hibernate.validator.constraints.NotBlank;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户端请求参数头（通用参数模型）
 */
public class ApiReqHead {

	@NotBlank
	private String token;
	@NotBlank
	private String account;
	/**
	 * Web、iOS、Android\C#
	 */
	@NotBlank
	private String time;
	@NotBlank
	private String client;
	/**
	 * 客户端版本
	 */
	private String version;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Map<String,String> toMap(){
		Map<String,String> map = new HashMap<String, String>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			String obj;
			try {
				obj = field.get(this).toString();
				if(obj!=null){
					map.put(field.getName(), obj);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public HttpSession getSession(){
		return httpServletRequest.getSession();
	}

	public void setSessionAttr(String key,Object value){
		getSession().setAttribute(key,value);
	}

	public Object getSessionAttr(String key){
		return getSession().getAttribute(key);
	}

}
