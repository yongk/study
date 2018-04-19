package com.ruirui.spring.aop.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProxyFactoryBeanTest {

    @Autowired
    ApplicationContext ctx;

    /**
     * 基于接口的代理。
     */
    @Test
    public void testProxyCreateSuccessfully() {
        PersonManager personManager = (PersonManager) ctx.getBean("personManager");
        List<Person> personList = personManager.findAll();
        assertThat(personList.size()).isEqualTo(1);
    }
}
