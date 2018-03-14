package com.ruirui.spring.webmvc.advice.simple;

import com.ruirui.spring.webmvc.advice.includestringreturntype.ResponseBodyWrapperAdviceIncludeStringReturnType;
import com.ruirui.spring.webmvc.dto.SuccessResponseBody;
import com.ruirui.spring.webmvc.dto.impl.DefaultSuccessResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * ResponseBodyAdvice实现，将标注为@ResponseBody的结果包装成{@link SuccessResponseBody}接口形式再返回。
 * <p>
 *     此实现不能包装返回类型是String的方法，需要此功能，使用{@link ResponseBodyWrapperAdviceIncludeStringReturnType}。
 * </p>
 *
 * @see com.ruirui.spring.webmvc.dto.SuccessResponseBody
 */
@ControllerAdvice
public class ResponseBodyWrapperAdvice implements ResponseBodyAdvice<Object> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (logger.isDebugEnabled()) {
            logger.debug("Wrap: " + body);
        }
       return new DefaultSuccessResponseBody(body);
    }
}
