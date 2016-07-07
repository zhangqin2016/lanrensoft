package zhang.lao.pojo.resp;

import com.alibaba.fastjson.JSON;

/**
 * <p>
 * title:js跨域问题
 * </p>
 * <p>
 * description:
 * </p>
 * 
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月15日
 */
public class CommonResp {
	
	/**
	 * 跨域变量
	 */
	public static final String cross_domain="cross_domain";
	
	/**
	 * 转化成跨域的json
	 * @param httpResult
	 * @param cross_domain
	 * @return
	 */
	public static String getJson(HttpResult httpResult,String cross_domain){
		if(cross_domain!=null&&cross_domain.length()>0){
			return cross_domain+"("+JSON.toJSONString(httpResult)+")";
		}
		return JSON.toJSONString(httpResult);
	}
	
	/**
	 * 转化成普通的json
	 * @param httpResult
	 * @return
	 */
	public static String getJson(HttpResult httpResult){
		return JSON.toJSONString(httpResult);
	}
	/**
	 * 转化成普通的json
	 * @return
	 */
	public static String objectToJson(Object o){
		return JSON.toJSONString(o);
	}


	public static HttpResult getSuccess(){
		return new HttpResult(HttpResult.status_sucess,HttpResult.status_sucess_message);
		
	}
	public static HttpResult getError(){
		return new HttpResult(HttpResult.status_error,HttpResult.status_error_message);
		
	}
	public static HttpResult getCodeError(String code){
		return new HttpResult(HttpResult.status_error,HttpResult.status_error_message,code);
		
	}
	public static HttpResult getError(String message){
		return new HttpResult(HttpResult.status_error,message);
		
	}
	public static HttpResult getError(String message,String code){
		return new HttpResult(HttpResult.status_error,message,code);
		
	}
	public static HttpResult getSuccessByMessage(String message){
		return new HttpResult(HttpResult.status_sucess,message);
		
	}
	
	public static HttpResult getSuccess(String message,Object data){
		return new HttpResult(HttpResult.status_sucess,data,message);
		
	}
	public static HttpResult getSuccess(Object data){
		return new HttpResult(HttpResult.status_sucess,data,HttpResult.status_sucess_message);
		
	}
	
	public static HttpResult getParamError(){
		return new HttpResult(HttpResult.status_error,HttpResult.code_error_param_message,HttpResult.code_param_error);
	}
	
	public static HttpResult getNoFindDataError(){
		return new HttpResult(HttpResult.status_error,HttpResult.code_nodata_message,HttpResult.code_nofind_error);
	}
	
	public static HttpResult getNoPermissionError(){
		return new HttpResult(HttpResult.status_no_permission,HttpResult.status_no_permission_message);
	}
	
}
