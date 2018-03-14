package com.ruirui.spring.webmvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = HelloController.class)
public class ControllerAdviceTest {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void string() throws Exception {
        mockMvc.perform(get("/string")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"));
    }

    @Test
    public void bool() throws Exception {
        mockMvc.perform(get("/bool")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"));
    }

    @Test
    public void void_() throws Exception {
        mockMvc.perform(get("/void")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.data").doesNotExist());
    }
}
