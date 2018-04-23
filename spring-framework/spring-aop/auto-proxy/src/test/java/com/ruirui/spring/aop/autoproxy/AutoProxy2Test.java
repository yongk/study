package com.ruirui.spring.aop.autoproxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class AutoProxy2Test {

    @Autowired
    ApplicationContext ctx;

    /**
     * 使用{@link DefaultAdvisorAutoProxyCreator}自动生成Proxy对象。
     * <p>仅需配置<code>DefaultAdvisorAutoProxyCreator</code>和<code>Advisor</code>就可自动生成Proxy。</p>
     */
    @Test
    public void testAutoProxy() {
        PersonManager personManager = (PersonManager) ctx.getBean("personManager");
        List<Person> personList = personManager.findAll();
        assertThat(personList.size()).isEqualTo(1);
    }
}
