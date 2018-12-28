package zhang.lao.pojo.console.resp;

public class HttpResult<T> {


	/**
	 * 接口返回码
	 */
	private int code;
	/**
	 * 错误信息
	 */
	private String message;

	private int errorCode;

	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public HttpResult(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public HttpResult(int code, String message, int errorCode) {
		this.code = code;
		this.message = message;
		this.errorCode = errorCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public HttpResult() {
	}

	public HttpResult(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}


}
