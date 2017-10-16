package zhang.lao.pojo.api.resp;


/**
 * 接口错误码
 **/
public enum ApiResultEnum {

    SUCCESS(1, "成功"), 
    VERIFY_CODE_ERROR(0, "鉴权失败",40001),
    JSSON_ERROR(0, "json数据结构不匹配",40002),
   PARAMEERROR(0, "参数不完整",40003),
    MAXSIZEUPLOAD(0, "上传文件太大",90001);
    private int code;
    private String message;
    private int errorCode;

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

    ApiResultEnum(int code, String message, int errorCode) {
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
    }

    ApiResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}