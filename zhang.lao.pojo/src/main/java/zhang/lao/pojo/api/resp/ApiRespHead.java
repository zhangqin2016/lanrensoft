package zhang.lao.pojo.api.resp;

/**
 * 
* @ClassName: ApiRespHead 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhangqin
* @date 2016年4月11日 下午1:47:37 
*
 */
public class ApiRespHead {

    /**
     * 接口返回码
     */
    private int code;
    /**
     * 错误信息
     */
    private String message;

    private String errorCode;

    
    public ApiRespHead() {

    }
    public ApiRespHead(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiRespHead(int code, String message, String errorCode) {
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
