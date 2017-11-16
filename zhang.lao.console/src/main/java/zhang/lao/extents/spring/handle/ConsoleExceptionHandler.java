package zhang.lao.extents.spring.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.extents.spring.ViewFactory;
import zhang.lao.pojo.console.ConsoleException;
import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultEnum;
import zhang.lao.pojo.console.resp.HttpResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 张钦 on 2016/7/15.
 */
public class ConsoleExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleExceptionHandler.class);

    private DomainJsonView domainJsonView;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        logger.error(ex.getMessage(),ex);
        if (ex instanceof ConsoleException) {
            ConsoleException exception = ConsoleException.class.cast(ex);
            if(exception.getHttpResultEnum().equals(HttpResultEnum.NOLOGIN)){
                ModelAndView mv = new ModelAndView("redirect:/console/login");
                return mv;
            }
            ModelAndView modelAndView = new ModelAndView();
            HttpResult httpResult = new HttpResult();
            httpResult.setMessage(exception.getHttpResultEnum().getMessage());
            httpResult.setErrorCode(exception.getHttpResultEnum().getErrorCode());
            httpResult.setCode(exception.getHttpResultEnum().getCode());
            modelAndView.addObject(httpResult);
            modelAndView.setView(domainJsonView);
            return modelAndView;
        }else if(ex instanceof MaxUploadSizeExceededException ){

            return   ViewFactory.buildApiJsonpView(HttpResultUtil.buildError(HttpResultEnum.FAILFILEISMORE));

        }else{

            return   ViewFactory.buildApiJsonpView(HttpResultUtil.buildError(HttpResultEnum.FAILSYS));
        }

    }

    public void setDomainJsonView(DomainJsonView domainJsonView) {
        this.domainJsonView = domainJsonView;
    }
}
