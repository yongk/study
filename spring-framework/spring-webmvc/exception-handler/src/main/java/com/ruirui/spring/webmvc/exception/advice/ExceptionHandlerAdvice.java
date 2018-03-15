package com.ruirui.spring.webmvc.exception.advice;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException() {
        return ImmutableMap.of("code", "500");
    }
}
