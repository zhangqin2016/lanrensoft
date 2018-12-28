package zhang.lao.pojo.console.resp;

/**
 * Created by zhangqin on 2017/7/14.
 */
public enum HttpResultEnum {
    ROLENOPERMISSION("您没有权限访问",0,70001),
    FAIL("请求失败",0),
    NOLOGIN("没有登录",0,50002),
    OLDPASSWORDERROR("原始密码错误",0),
    FAILSYS("系统异常",0,90001),
    SUCCESS("请求成功",1),
    HASUSER("已经存在该账户(手机、邮箱、账户)",0,60001),
    REPEATSUBMIT("重复提交",0,60001),

    UPLOADERROR("上传文件失败",0),
    FAILFILEISMORE("上传文件失败，文件过大",0)

    ;

    private String message;
    private int code;
    private int errorCode;

    HttpResultEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public int getErrorCode() {
        return errorCode;
    }

    HttpResultEnum(String message, int code, int errorCode) {
        this.message = message;
        this.code = code;
        this.errorCode = errorCode;
    }
}
