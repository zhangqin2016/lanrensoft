package zhang.lao.pojo.resp.api;


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
    ERROR_DEFINED(0,""),
    PARAMERROR(0, "参数不完整，或者传输有误。"), 
    multipart_ERROR(0,"提交方式需为multipart/form-data"),
    NOMORETIME(0, "您好您的卡片授权次数已经用完！"),
    ALREADYSQ(0, "您的设备已经认证过了！"),
    SIGNERROR(0, "签名不正确"),

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

	public void setBaseDesc(String baseDesc) {
		this.baseDesc = baseDesc;
	}
	public ApiResultCode setMsg(String baseDesc) {
		this.baseDesc = baseDesc;
		return this;
	}
    

}
