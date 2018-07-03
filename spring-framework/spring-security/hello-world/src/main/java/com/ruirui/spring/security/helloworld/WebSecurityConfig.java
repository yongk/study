package com.ruirui.spring.security.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{bcrypt}$2a$10$TnJ1bdJ3JIzGZC/jVS.v3eXlr3ns0hDxeRtlia0CPQfLJVaRCWJVS") // 123
                .roles("USER");
    }

}
