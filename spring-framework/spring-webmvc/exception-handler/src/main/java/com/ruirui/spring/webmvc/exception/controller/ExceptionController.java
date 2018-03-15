package com.ruirui.spring.webmvc.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/runtime")
    public String runtime() {
        throw new RuntimeException();
    }


    // 优先级高于@ControllerAdvice中的@ExceptionHandler方法。
    // @see ExceptionHandlerExceptionResolver#getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception)
//    @ExceptionHandler(RuntimeException.class)
//    public Map<String, Object> handleException(RuntimeException ex) {
//        return ImmutableMap.of("code", "500");
//    }
}
