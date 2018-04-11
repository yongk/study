package com.ruirui.webmvc.exception.translator.advice;

import com.ruirui.webmvc.exception.translator.dto.annotation.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class HandlerExceptionTranslatorAdvice {

    @ExceptionHandler(Exception.class)
    public ErrorMessage handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(500);
        return new ErrorMessage("Unauthorized", "Bad credentials", request.getRequestURI());
    }
}
