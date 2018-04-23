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
@ContextConfiguration("classpath:applicationContext.xml")
public class AutoProxyTest {

    @Autowired
    ApplicationContext ctx;

    /**
     * 使用BeanNameAutoProxyCreator自动生成Proxy对象。
     */
    @Test
    public void testAutoProxy() {
        PersonManager personManager = (PersonManager) ctx.getBean("personManager");
        List<Person> personList = personManager.findAll();
        assertThat(personList.size()).isEqualTo(1);

        PersonManager personManager2 = (PersonManager) ctx.getBean("personManager2"); //单实例的advice应用到了所有的target
        List<Person> personList2 = personManager2.findAll();
        assertThat(personList2.size()).isEqualTo(1);
    }
}
