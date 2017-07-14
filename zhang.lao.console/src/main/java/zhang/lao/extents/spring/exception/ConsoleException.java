package zhang.lao.extents.spring.exception;


import zhang.lao.pojo.console.resp.HttpResultEnum;

/**
 * Created by tech6 on 2016/7/15.
 */

    public class ConsoleException extends RuntimeException {

        private int code;
        private String message;
        private int errorCode;

    public ConsoleException(HttpResultEnum httpResultEnum) {
        this.code = httpResultEnum.getCode();
        this.message = httpResultEnum.getMessage();
        this.errorCode = httpResultEnum.getErrorCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
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
}
