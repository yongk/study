package com.ruirui.spring.webmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@Configuration
@ComponentScan("com.ruirui.spring.webmvc.advice.simple")
@EnableWebMvc
public class HelloController {

    @GetMapping("/string")
    public String string() {
        return "Hello world";
    }

    @GetMapping("/bool")
    public Boolean bool() {
        return Boolean.TRUE;
    }

    @GetMapping("/void")
    public void void_() {
    }
}
