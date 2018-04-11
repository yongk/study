package com.ruirui.webmvc.exception.translator.advice;

import com.ruirui.webmvc.exception.translator.ExceptionTranslatorApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration()
@ContextHierarchy({
        @ContextConfiguration(name = "parent", classes = {ExceptionTranslatorApplication.class}),
        @ContextConfiguration(name = "child",  locations = "file:src/main/webapp/WEB-INF/mvc-servlet.xml")
})
public class HandlerExceptionTranslatorAdviceTest {
    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testRuntimeException() throws Exception {
        mockMvc.perform(get("/runtime")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(log())
                .andExpect(status().is(500))
                .andExpect(jsonPath("$.status").value("500"));
    }
}
