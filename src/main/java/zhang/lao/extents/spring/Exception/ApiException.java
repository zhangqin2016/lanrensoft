package zhang.lao.extents.spring.exception;


/**
 * Created by tech6 on 2016/7/15.
 */

    public class ApiException extends RuntimeException {

        private String apiMessage;
        private int apiCode;
        private String apiErrorCode;
        private String doMain;

    public String getDoMain() {
        return doMain;
    }

    public void setDoMain(String doMain) {
        this.doMain = doMain;
    }

    public String getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(String apiMessage) {
        this.apiMessage = apiMessage;
    }

    public int getApiCode() {
        return apiCode;
    }

    public void setApiCode(int apiCode) {
        this.apiCode = apiCode;
    }

    public String getApiErrorCode() {
        return apiErrorCode;
    }

    public void setApiErrorCode(String apiErrorCode) {
        this.apiErrorCode = apiErrorCode;
    }

    public ApiException(String apiErrorCode, String apiMessage, int apiCode) {
        super(apiMessage);
        this.apiErrorCode = apiErrorCode;
        this.apiMessage = apiMessage;
        this.apiCode = apiCode;
    }
    public ApiException(String apiMessage, int apiCode) {
        super(apiMessage);
        this.apiMessage = apiMessage;
        this.apiCode = apiCode;
    }
    public ApiException(String apiMessage, int apiCode,String doMain) {
        super(apiMessage);
        this.apiMessage = apiMessage;
        this.apiCode = apiCode;
        this.doMain=doMain;
    }
    public ApiException(String apiMessage,int apiCode, String apiErrorCode,String doMain) {
        super(apiMessage);
        this.apiMessage = apiMessage;
        this.apiCode = apiCode;
        this.doMain=doMain;
        this.apiErrorCode=apiErrorCode;
    }
}
