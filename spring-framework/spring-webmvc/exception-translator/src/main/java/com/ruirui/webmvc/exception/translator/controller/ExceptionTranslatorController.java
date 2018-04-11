package com.ruirui.webmvc.exception.translator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTranslatorController {

    @PostMapping("/void")
    public void enhanceVoid() {
    }

    @GetMapping("/runtime")
    public void runtimeException() {
        throw new RuntimeException("Intend throw");
    }
}
