package com.ruirui.spring.aop.autoproxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class AutoProxy3Test {

    @Autowired
    ApplicationContext ctx;


    /**
     * 基于注解（元数据驱动）的自动代理。
     */
    @Test
    public void testAutoProxy() {
        PersonManager personManager = (PersonManager) ctx.getBean("personManager");
        List<Person> personList = personManager.findAll();
        assertThat(personList.size()).isEqualTo(1);
    }
}
