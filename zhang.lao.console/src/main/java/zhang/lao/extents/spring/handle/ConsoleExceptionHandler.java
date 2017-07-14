package zhang.lao.extents.spring.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.build.kit.LogKit;
import zhang.lao.extents.spring.ViewFactory;
import zhang.lao.extents.spring.exception.ConsoleException;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultEnum;
import zhang.lao.pojo.console.resp.HttpResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tech6 on 2016/7/15.
 */
public class ConsoleExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleExceptionHandler.class);

    private DomainJsonView domainJsonView;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        if (ex instanceof ConsoleException) {
            ConsoleException exception = ConsoleException.class.cast(ex);
            ModelAndView modelAndView = new ModelAndView();
            HttpResult httpResult = new HttpResult();
            httpResult.setMessage(exception.getMessage());
            httpResult.setErrorCode(exception.getErrorCode());
            httpResult.setCode(exception.getCode());
            modelAndView.addObject(httpResult);
            modelAndView.setView(domainJsonView);
            return modelAndView;
        }else if(ex instanceof MaxUploadSizeExceededException ){
            return   ViewFactory.buildApiJsonpView(HttpResultUtil.buildError(HttpResultEnum.FAILFILEISMORE));

        }else{
            LogKit.error(ex.getMessage(),ex);
            return   ViewFactory.buildApiJsonpView(HttpResultUtil.buildError(HttpResultEnum.FAILSYS));
        }

    }

    public void setDomainJsonView(DomainJsonView domainJsonView) {
        this.domainJsonView = domainJsonView;
    }
}
