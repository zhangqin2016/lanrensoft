package zhang.lao.console.handle;


/**
 * Created by tech6 on 2016/7/15.
 */

    public class ConsoleException extends RuntimeException {

        private String consoleMessage;
        private String consoleCode;
        private String consoleErrorCode;

    public String getConsoleMessage() {
        return consoleMessage;
    }

    public void setConsoleMessage(String consoleMessage) {
        this.consoleMessage = consoleMessage;
    }

    public String getConsoleCode() {
        return consoleCode;
    }

    public void setConsoleCode(String consoleCode) {
        this.consoleCode = consoleCode;
    }

    public String getConsoleErrorCode() {
        return consoleErrorCode;
    }

    public void setConsoleErrorCode(String consoleErrorCode) {
        this.consoleErrorCode = consoleErrorCode;
    }

    public ConsoleException(String consoleErrorCode, String consoleMessage, String consoleCode) {
        super(consoleMessage);
        this.consoleErrorCode = consoleErrorCode;
        this.consoleMessage = consoleMessage;
        this.consoleCode = consoleCode;
    }
    public ConsoleException(String consoleMessage, String consoleCode) {
        super(consoleMessage);
        this.consoleMessage = consoleMessage;
        this.consoleCode = consoleCode;
    }
}
