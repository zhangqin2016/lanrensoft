package zhang.lao.extents.spring.handle;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.commons.fileupload.FileUploadBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.extents.spring.ViewFactory;
import zhang.lao.pojo.api.resp.ApiRespData;
import zhang.lao.pojo.api.resp.ApiResultCode;
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;

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
            httpResult.setMessage(exception.getConsoleMessage());
            httpResult.setCode(exception.getConsoleErrorCode());
            httpResult.setHttp_status(exception.getConsoleCode());
            modelAndView.addObject(httpResult);
            modelAndView.setView(domainJsonView);
            return modelAndView;
        }else if(ex instanceof MaxUploadSizeExceededException ){
            return   ViewFactory.buildApiJsonpView(CommonResp.getError("上传文件失败，文件过大"));

        }else{
            return   ViewFactory.buildApiJsonpView(CommonResp.getError(ex.getCause().getMessage()));
        }

    }

    public void setDomainJsonView(DomainJsonView domainJsonView) {
        this.domainJsonView = domainJsonView;
    }
}
