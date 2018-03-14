package com.ruirui.spring.web.advice.includestringreturntype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruirui.spring.web.advice.simple.ResponseBodyWrapperAdvice;
import com.ruirui.spring.web.dto.impl.DefaultSuccessResponseBody;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 扩展{@link ResponseBodyWrapperAdvice}， 对返回类型是String的结果进行包装。
 */
@ControllerAdvice
public class ResponseBodyWrapperAdviceIncludeStringReturnType extends ResponseBodyWrapperAdvice {

    protected ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return StringHttpMessageConverter.class.isAssignableFrom(converterType) ||
                super.supports(returnType, converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (String.class.isAssignableFrom(returnType.getParameterType()) &&
                StringHttpMessageConverter.class.isAssignableFrom(selectedConverterType)) {
            return beforeStringBodyWrite((String) body, returnType, selectedContentType, selectedConverterType, request, response);
        }
        return super.beforeBodyWrite(body, returnType, selectedContentType, selectedConverterType, request, response);
    }

    protected String beforeStringBodyWrite(String body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (logger.isDebugEnabled()) {
            logger.debug("Wrap string: " + body);
        }
        DefaultSuccessResponseBody wrapper = new DefaultSuccessResponseBody(body);
        try {
            return objectMapper.writeValueAsString(wrapper);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Cannot serialize " + wrapper + " to json", e);
        }
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        if (objectMapper == null) {
            throw new IllegalArgumentException("objectMapper must not be null");
        }
        this.objectMapper = objectMapper;
    }
}
