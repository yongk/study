package com.ruirui.spring.beans;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class BeanDefinitionOverrideTest {

    @Test
    public void testOverride() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        int count = reader.loadBeanDefinitions("/base-config.xml", "override-config.xml");

        assertThat(count).isEqualTo(1);
        assertThat(factory.getBean(UserRepository.class)).isInstanceOf(MongoUserRepository.class);
        assertThat(factory.getBean(MongoUserRepository.class)).isNotNull();
        try {
            assertThat(factory.getBean(JdbcUserRepository.class));
            fail("Expected exception not throw");
        } catch (BeansException e) {
            assertThat(e).isInstanceOf(NoSuchBeanDefinitionException.class);
        }
    }

    @Test
    public void testNonOverride() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        int count = reader.loadBeanDefinitions("/base-config.xml", "nonoverride-config.xml");

        assertThat(count).isEqualTo(2);
        assertThat(factory.getBean(MongoUserRepository.class)).isNotNull();
        assertThat(factory.getBean(JdbcUserRepository.class)).isNotNull();
        try {
            assertThat(factory.getBean(UserRepository.class));
            fail("Expected exception not throw");
        } catch (BeansException e) {
            assertThat(e).isInstanceOf(NoUniqueBeanDefinitionException.class);
            assertThat(e).hasMessageStartingWith("No qualifying bean of type " +
                    "'com.ruirui.spring.beans.UserRepository' available: " +
                    "expected single matching bean but found 2");
        }
    }
}
