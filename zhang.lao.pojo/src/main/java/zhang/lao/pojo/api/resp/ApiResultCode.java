package zhang.lao.pojo.api.resp;


/**
 * 接口错误码
 **/
public enum ApiResultCode {

    SUCCESS(1, "成功"), 
    FAIL(0, "失败"), 
    VERIFY_CODE_ERROR(-1, "没有权限访问"),
    BODYISNULL(0, "body不能为空"), 
    HEADISNULL(0, "head不能为空"), 
    JSSON_ERROR(0, "JSON转化错误"),
    TIMEISUSELESS(0, "时间戳已经过期"),
    /**
     * 系统创建TOKEN失败
     */
    CREATETOKENERROR(0, "系统创建TOKEN失败"),
    /**
     * 系统创建TOKEN失败
     */
    SIGNERROR(0, "签名错误"),
    MAXSIZEUPLOAD(0, "上传文件太大"),
    multipart_ERROR(0,"提交方式需为multipart/form-data")
    ;
    private int code;
    private String baseDesc;
    private int codeStatus;

    ApiResultCode(int code, String baseDesc) {
        this.code = code;
        this.baseDesc = baseDesc;
    }

	private ApiResultCode(int code, int codeStatus, String baseDesc) {
		this.code = code;
		this.baseDesc = baseDesc;
		this.codeStatus = codeStatus;
	}

	public int getCode() {
        return code;
    }

    public String getBaseDesc() {
        return baseDesc;
    }


	public int getCodeStatus() {
		return codeStatus;
	}


}
