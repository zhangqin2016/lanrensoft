package zhang.lao.extents.spring.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.extents.spring.ViewFactory;
import zhang.lao.extents.spring.exception.ApiException;
import zhang.lao.pojo.api.resp.ApiRespData;
import zhang.lao.pojo.api.resp.ApiRespHead;
import zhang.lao.pojo.api.resp.ApiResultEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 张钦 on 2016/7/15.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    private DomainJsonView domainJsonView;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        if (ex instanceof ApiException) {
            ApiException exception = ApiException.class.cast(ex);
            ApiRespData<Object> objectApiRespData = ApiRespData.buildFail(exception.getApiResultEnum());
            ApiRespHead head = objectApiRespData.getHead();
            head.setErrorCode(exception.getApiResultEnum().getErrorCode());
            head.setMessage(exception.getApiResultEnum().getMessage());
            objectApiRespData.setHead(head);
            logger.error(exception.getMessage(),ex);
            return   ViewFactory.buildFastJsonView(objectApiRespData);
        }else if(ex instanceof MaxUploadSizeExceededException){
            return   ViewFactory.buildFastJsonView(ApiRespData.buildFail(ApiResultEnum.MAXSIZEUPLOAD));

        }else{
            return null;
        }

    }

    public void setDomainJsonView(DomainJsonView domainJsonView) {
        this.domainJsonView = domainJsonView;
    }
}
