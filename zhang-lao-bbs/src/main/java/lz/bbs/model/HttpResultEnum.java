package lz.bbs.model;

/**
 * Created by Administrator on 2017/3/23.
 */
public enum HttpResultEnum {
    success("1","操作成功"),
    error("0","操作失败"),
    ;
    private String code;
    private String message;
    private String errorCode;
    HttpResultEnum(String code, String messagee) {
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
    }
    HttpResultEnum(String code, String message, String errorCode) {
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
