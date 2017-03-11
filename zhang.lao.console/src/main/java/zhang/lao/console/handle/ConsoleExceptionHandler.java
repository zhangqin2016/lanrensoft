package zhang.lao.console.handle;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.pojo.console.resp.HttpResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tech6 on 2016/7/15.
 */
public class ConsoleExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleExceptionHandler.class);

    private FastJsonJsonView exceptionView;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {


        if (ex instanceof ConsoleException) {
            ConsoleException exception = ConsoleException.class.cast(ex);
            ModelAndView modelAndView = new ModelAndView();
            HttpResult httpResult = new HttpResult();
            httpResult.setMessage(exception.getConsoleMessage());
            httpResult.setCode(exception.getConsoleErrorCode());
            httpResult.setHttp_status(exception.getConsoleCode());
            modelAndView.addObject(httpResult);
            modelAndView.setView(exceptionView);
            return modelAndView;
        }else{
            return null;
        }

    }

    public void setExceptionView(FastJsonJsonView exceptionView) {
        this.exceptionView = exceptionView;
    }
}
