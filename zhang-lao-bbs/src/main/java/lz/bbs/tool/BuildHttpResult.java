package lz.bbs.tool;

import lz.bbs.model.HttpResult;
import lz.bbs.model.HttpResultEnum;

/**
 * Created by Administrator on 2017/3/23.
 */
public class BuildHttpResult {

    public static HttpResult successData(Object t){
        HttpResult httpResult = new HttpResult();
        httpResult.setData(t);
        httpResult.setMessage(HttpResultEnum.success.getMessage());
        httpResult.setCode(HttpResultEnum.success.getCode());
        return httpResult;
    }
    public static HttpResult success(){
        HttpResult httpResult = new HttpResult();
        httpResult.setMessage(HttpResultEnum.success.getMessage());
        httpResult.setCode(HttpResultEnum.success.getCode());
        return httpResult;
    }
    public static HttpResult result(HttpResultEnum httpResultEnum){
        HttpResult httpResult = new HttpResult();
        httpResult.setMessage(HttpResultEnum.success.getMessage());
        httpResult.setCode(HttpResultEnum.success.getCode());
        return httpResult;
    }
}
