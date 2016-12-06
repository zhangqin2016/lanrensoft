package zhang.lao.pojo.resp.api;


/**
 * 
* @ClassName: ApiRespData 
* @Description: 请求返回工具类 
* @author zhangqin
* @date 2016年4月11日 下午1:48:02 
* 
* @param <T>
 */
public class ApiRespData<T> {

    /**
     * 返回信息头
     */
    private ApiRespHead head;
    /**
     * 返回信息体
     */
	
    private T body;

    public ApiRespData() {
    }

    private ApiRespData(ApiResultCode resultCode, T body) {
        this.head = new ApiRespHead(resultCode.getCode(), resultCode.getBaseDesc());
        this.body = body;
    }
    private ApiRespData(int code ,String message,String errorCode,T body) {
        this.head = new ApiRespHead(code,message,errorCode);
        this.body = body;
    }

    private ApiRespData(ApiResultCode resultCode, T body, String errMsg) {
        this.head = new ApiRespHead(resultCode.getCode(), errMsg);
        this.body = body;
    }
    private ApiRespData(ApiResultCode resultCode, T body, String errMsg,String errorCode) {
        this.head = new ApiRespHead(resultCode.getCode(), errMsg,errorCode);
        this.body = body;
    }

    public static <T> ApiRespData<T> buildSucc(T result) {
        return new ApiRespData<T>(ApiResultCode.SUCCESS, result);
    }
    public static <T> ApiRespData<T> buildSucc() {
        return new ApiRespData<T>(ApiResultCode.SUCCESS, null);
    }
    public static <T> ApiRespData<T> buildFail(ApiResultCode resultCode, T result) {
        return new ApiRespData<T>(resultCode, result);
    }
    public static <T> ApiRespData<T> buildFail() {
        return new ApiRespData<T>(ApiResultCode.FAIL, null);
    }
    public static <T> ApiRespData<T> buildFail(ApiResultCode resultCode) {
        return new ApiRespData<T>(resultCode, null);
    }
    public static <T> ApiRespData<T> buildFailErrorCode(ApiResultCode resultCode, String errorCode) {
        return new ApiRespData<T>(resultCode, null,resultCode.getBaseDesc(),errorCode);
    }
    public static <T> ApiRespData<T> buildFailErrorCode(ApiResultCode resultCode, String errorCode,String message) {
        return new ApiRespData<T>(resultCode, null,message,errorCode);
    }
    public static <T> ApiRespData<T> build(int code ,String message, String errorCode,T result) {
        return new ApiRespData<T>(code, message, errorCode,result);
    }
    public static <T> ApiRespData<T> buildFail(ApiResultCode resultCode, T result, String errorMsg) {
        return new ApiRespData<T>(resultCode, result, errorMsg);
    }
    public static <T> ApiRespData<T> buildFail(ApiResultCode resultCode, String errorMsg) {
        return new ApiRespData<T>(resultCode,null, errorMsg);
    }

    public ApiRespHead getHead() {
        return head;
    }

    public void setHead(ApiRespHead head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
    
    
}
