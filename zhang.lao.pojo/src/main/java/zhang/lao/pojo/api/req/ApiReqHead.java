package zhang.lao.pojo.api.req;

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
	
	private String token;

	/**
	 * Web、iOS、Android
	 */

	private String client;
	/**
	 * 客户端版本
	 */
	private String versionCode;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;


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
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
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
