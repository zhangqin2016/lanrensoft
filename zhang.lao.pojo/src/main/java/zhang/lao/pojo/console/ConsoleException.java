package zhang.lao.pojo.console;


import zhang.lao.pojo.console.resp.HttpResultEnum;

/**
 * Created by tech6 on 2016/7/15.
 */

    public class ConsoleException extends RuntimeException {

      private HttpResultEnum httpResultEnum;

    public ConsoleException(HttpResultEnum httpResultEnum) {
        this.httpResultEnum = httpResultEnum;
    }

    public HttpResultEnum getHttpResultEnum() {
        return httpResultEnum;
    }

    public void setHttpResultEnum(HttpResultEnum httpResultEnum) {
        this.httpResultEnum = httpResultEnum;
    }
}
