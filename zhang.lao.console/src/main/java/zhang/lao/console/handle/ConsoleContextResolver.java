package zhang.lao.console.handle;/*
 * Copyright (c) 2016 Yee Sight. All Rights Reserved.
 */

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import zhang.lao.console.model.common.ConsoleContext;
import zhang.lao.console.model.login.LoginUserModel;

import javax.servlet.http.HttpServletRequest;

public class ConsoleContextResolver implements HandlerMethodArgumentResolver {
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(ConsoleContext.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        LoginUserModel loginUserModel = (LoginUserModel) servletRequest.getSession().getAttribute("user");
        ConsoleContext consoleContext = new ConsoleContext();
        consoleContext.setLoginUserModel(loginUserModel);
        return consoleContext;
    }


}
