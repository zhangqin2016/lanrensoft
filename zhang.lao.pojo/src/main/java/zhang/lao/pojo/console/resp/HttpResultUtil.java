package zhang.lao.pojo.console.resp;

public class HttpResultUtil<T> {

	public static HttpResult buildSuccess(){
		HttpResult  objectHttpResult = new HttpResult(HttpResultEnum.SUCCESS.getCode(),HttpResultEnum.SUCCESS.getMessage());
		return objectHttpResult;
	}
	public static <T>HttpResult<T> buildSuccess(T t){
		HttpResult  objectHttpResult = new HttpResult(HttpResultEnum.SUCCESS.getCode(),HttpResultEnum.SUCCESS.getMessage(),t);
		return objectHttpResult;
	}

	public static HttpResult buildError(HttpResultEnum t){
		HttpResult  objectHttpResult = new HttpResult(t.getCode(),t.getMessage(),t.getErrorCode());
		return objectHttpResult;
	}
}
