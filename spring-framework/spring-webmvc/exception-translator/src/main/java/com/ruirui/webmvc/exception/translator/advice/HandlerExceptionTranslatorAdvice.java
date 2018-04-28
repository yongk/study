package com.ruirui.webmvc.exception.translator.advice;

import com.ruirui.webmvc.exception.translator.dto.annotation.ErrorMessage;
import com.ruirui.webmvc.exception.translator.dto.annotation.SimpleErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class HandlerExceptionTranslatorAdvice {

    private final Logger logger = LoggerFactory.getLogger(HandlerExceptionTranslatorAdvice.class);

    @ExceptionHandler(Exception.class)
    public ErrorMessage handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("Catch handler exception", ex);

        response.setStatus(500);
        return new SimpleErrorMessage("Unknown", "未知错误", request.getRequestURI());
    }
}
