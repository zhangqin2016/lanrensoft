package zhang.lao.extents.spring.handle;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.extents.spring.exception.ApiException;
import zhang.lao.pojo.resp.api.ApiRespHead;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tech6 on 2016/7/15.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    private ExceptionView exceptionView;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {


        if (ex instanceof ApiException) {
            ApiException exception = ApiException.class.cast(ex);
            ModelAndView modelAndView = new ModelAndView();
            ApiRespHead apiRespHead = new ApiRespHead();
            apiRespHead.setMessage(exception.getMessage());
            apiRespHead.setCode(exception.getApiCode());
            apiRespHead.setErrorCode(exception.getApiErrorCode());
            modelAndView.addObject("head",apiRespHead);
            if(StringUtils.isNotBlank(exception.getDoMain())){
                exceptionView.setDomain(exception.getDoMain());
            }else{
                //DO NOTHING
            }
            modelAndView.setView(exceptionView);
            return modelAndView;
        }else{
            return null;
        }

    }

    public void setExceptionView(ExceptionView exceptionView) {
        this.exceptionView = exceptionView;
    }
}
