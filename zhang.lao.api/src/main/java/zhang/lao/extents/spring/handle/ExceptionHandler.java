package zhang.lao.extents.spring.handle;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.extents.spring.ViewFactory;
import zhang.lao.extents.spring.exception.ApiException;
import zhang.lao.pojo.api.resp.ApiRespData;
import zhang.lao.pojo.api.resp.ApiRespHead;
import zhang.lao.pojo.api.resp.ApiResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tech6 on 2016/7/15.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    private DomainJsonView domainJsonView;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        if (ex instanceof ApiException) {
            ApiException exception = ApiException.class.cast(ex);
            ApiRespData<Object> objectApiRespData = ApiRespData.buildFail(ApiResultCode.FAIL);
            ApiRespHead head = objectApiRespData.getHead();
            head.setErrorCode(exception.getApiErrorCode());
            head.setMessage(exception.getApiMessage());
            objectApiRespData.setHead(head);
            logger.error(exception.getMessage(),ex);
            return   ViewFactory.buildApiJsonpView(objectApiRespData,exception.getDoMain());
        }else if(ex instanceof MaxUploadSizeExceededException){
            return   ViewFactory.buildApiJsonpView(ApiRespData.buildFail(ApiResultCode.MAXSIZEUPLOAD));

        }else{
            return null;
        }

    }

    public void setDomainJsonView(DomainJsonView domainJsonView) {
        this.domainJsonView = domainJsonView;
    }
}
