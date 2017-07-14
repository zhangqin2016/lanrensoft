package zhang.lao.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.extents.spring.exception.ConsoleException;
import zhang.lao.pojo.console.resp.HttpResultEnum;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created by tech6 on 2016/6/15.
 */
public class SubmitRepeatInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request,
                                 HttpServletResponse response, Object handler) throws Exception {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if (annotation != null) {
                boolean isAdd = annotation.isAdd();
                String tokenName = annotation.tokenName();
                if (isAdd) {
                    String common_token =  String.valueOf(new Random().nextLong());
                    request.getSession().setAttribute(tokenName,common_token);
                    request.setAttribute(tokenName,common_token);
                }else  {
                    String token = request.getParameter(tokenName);
                   Object tokenSession = request.getSession().getAttribute(tokenName);
                    String tokenIs = tokenSession ==null?"":tokenSession.toString();
                    if ((token==null?"":token).equals(tokenIs)) {
                        request.getSession().removeAttribute(tokenName);
                        return true;
                    } else {
                        throw new ConsoleException(HttpResultEnum.REPEATSUBMIT);
                    }
                }
            }
            return  true;
        }
        @Override
        public void postHandle(HttpServletRequest request,
                               HttpServletResponse response, Object handler,
                               ModelAndView modelAndView) throws Exception {
            // TODO Auto-generated method stub

        }
        @Override
        public void afterCompletion(HttpServletRequest request,
                                    HttpServletResponse response, Object handler, Exception ex)
                throws Exception {
            // TODO Auto-generated method stub

        }

    }
