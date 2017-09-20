package zhang.lao.extents.spring.exception;


import zhang.lao.pojo.api.resp.ApiResultEnum;

/**
 * Created by tech6 on 2016/7/15.
 */

    public class ApiException extends RuntimeException {
    private  ApiResultEnum apiResultEnum;


    public ApiResultEnum getApiResultEnum() {
        return apiResultEnum;
    }

    public void setApiResultEnum(ApiResultEnum apiResultEnum) {
        this.apiResultEnum = apiResultEnum;
    }

    public ApiException(ApiResultEnum apiResultEnum) {
        this.apiResultEnum = apiResultEnum;
    }
}
