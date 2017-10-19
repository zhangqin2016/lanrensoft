package zhang.lao.extents.spring.handle;/*
 * Copyright (c) 2016 Yee Sight. All Rights Reserved.
 */

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import zhang.lao.build.kit.LogKit;
import zhang.lao.build.tool.MD5;
import zhang.lao.extents.spring.exception.ApiException;
import zhang.lao.extents.spring.exception.ExceptionFactory;
import zhang.lao.pojo.api.req.ApiReqBody;
import zhang.lao.pojo.api.req.ApiReqData;
import zhang.lao.pojo.api.req.ApiReqHead;
import zhang.lao.pojo.api.resp.ApiResultEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

public class ApiArgumentResolver implements HandlerMethodArgumentResolver {

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
        String requestBody =  getRequestBody(servletRequest);
        LogKit.info(requestBody);
        LogKit.info(servletRequest.getRequestURI());
        ApiReqData<ApiReqBody> data = null;
        try {
            data = JSON.parseObject(requestBody, parameter.getGenericParameterType());
        }catch (Exception e){
            throw new ApiException(ApiResultEnum.JSSON_ERROR);
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
                throw ExceptionFactory.buildApiException(ApiResultEnum.PARAMEERROR);
            }

            ApiData apiData = parameter.getParameterAnnotation(ApiData.class);
            if (apiData.tokenValidate()) {
                String token = data.getHead().getToken();
                String time = data.getHead().getTime();
                String account = data.getHead().getAccount();
                if(MD5.MD5Encode(time+"d09ee1289dc74sb3d977472cf11f6783"+account).equals(token)){
                  /*  if(new Date().getTime()/1000-Long.parseLong(time)>10){
                        throw new ApiException(ApiResultEnum.TOKENTIME);
                    }*/
                }else{
                    throw new ApiException(ApiResultEnum.TOKENERR);
                }
                return data;
            } else {
                return data;
            }
        }else{
            throw new ApiException(ApiResultEnum.JSSON_ERROR);
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


    public static void main(String[] args) {
        System.out.println(MD5.MD5Encode("1506565452"+"d09ee1289dc74sb3d977472cf11f6783"+"skAns"));
    }
}
