package com.ruirui.spring.aop.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class ProxyFactoryBean2Test {

    @Autowired
    ApplicationContext ctx;

    /**
     * target bean与proxy bean在工厂中共存。
     */
    @Test(expected = NoUniqueBeanDefinitionException.class)
    public void testTargetBeanAndProxyBeanCoexist() {
        AutowireCapableBeanFactory autowireCapableBeanFactory = ctx.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.getBean(PersonManager.class);
    }
}
