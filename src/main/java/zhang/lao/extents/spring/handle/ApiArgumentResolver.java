package zhang.lao.extents.spring.handle;/*
 * Copyright (c) 2016 Yee Sight. All Rights Reserved.
 */

import com.alibaba.fastjson.JSON;
import com.lz.kit.LogKit;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import zhang.lao.api.service.common.TokenService;
import zhang.lao.extents.spring.exception.ApiException;
import zhang.lao.pojo.req.api.ApiReqBody;
import zhang.lao.pojo.req.api.ApiReqData;
import zhang.lao.pojo.req.api.ApiReqHead;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

public class ApiArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private TokenService tokenService;

    /**
     * 请求参数名称
     */
    private final static String MSG = "msg";

    private Validator validator;

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ApiData.class);
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        // 增加解析url上带参数
        String requestBody = servletRequest.getParameter(MSG);
        if (StringUtils.isBlank(requestBody)) {
            requestBody = getRequestBody(servletRequest);
        }

        LogKit.info(requestBody);
        ApiReqData<ApiReqBody> data = null;
        try {
            data = JSON.parseObject(requestBody, parameter.getGenericParameterType());
        }catch (Exception e){
            throw new ApiException("json解析出错", 0);
        }
        if(data!=null) {
            if(data.getHead()==null){
                data.setHead(new ApiReqHead());
            }
            data.getHead().setHttpServletRequest(servletRequest);
            data.getHead().setHttpServletResponse(webRequest.getNativeResponse(HttpServletResponse.class));
            /**
             * 验证请求参数
             *
             */
            Set<ConstraintViolation<ApiReqData<ApiReqBody>>> constraintViolations = validator.validate(data);

            // 校验不通过则抛参数异常
            StringBuilder errorMsgBuiler = new StringBuilder();
            if (constraintViolations != null && constraintViolations.size() != 0) {
                for (ConstraintViolation violation : constraintViolations) {
                    errorMsgBuiler.append(violation.getPropertyPath());
                    errorMsgBuiler.append(":");
                    errorMsgBuiler.append(violation.getMessage());
                    errorMsgBuiler.append(". ");
                }

                throw new ApiException(errorMsgBuiler.toString(), 0, data.getHead().getCrossDomain());
            }

            ApiData apiData = parameter.getParameterAnnotation(ApiData.class);
            if (apiData.tokenValidate()) {
                ApiReqHead apiReqHead = data.getHead();
                String openid = apiReqHead.getOpenid();
                String token = apiReqHead.getToken();
                if ((tokenService.isCacheUsable(openid, token) || tokenService.isUsable(openid, token))) {
                    return data;
                } else {
                    throw new ApiException("无权限访问", -1, data.getHead().getCrossDomain());
                }
            } else {
                return data;
            }
        }else{
            throw new ApiException("JSON解析错误", 0);
        }

    }

    /**
     * 获取request中的请求体数据
     *
     * @param request
     * @return
     * @throws IOException
     */
    private final String getRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder(100);
        String readLine = "";
        try {
            while ((readLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(readLine);
            }
        } catch (Exception e) {
        } finally {
            IOUtils.closeQuietly(bufferedReader);
        }
        return stringBuilder.toString();
    }

    /**
     * 配置文件中注入验证器
     *
     * @param validator
     */
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

}
