package zhang.lao.extents.spring.exception;/**
 * Created by zhangqin on 2017/9/20.
 */

import zhang.lao.pojo.api.resp.ApiResultEnum;

/**
 * 异常工厂
 *
 * @author
 * @create 2017-09-20 15:28
 **/
public class ExceptionFactory {

    public static ApiException buildApiException(ApiResultEnum apiResultEnum){
        return new ApiException(apiResultEnum);
    }
}
