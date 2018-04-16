package com.ruirui.spring.xml;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 学习XML的命名空间是如何处理的。
 */
public class XmlNamespaceProcessTest {

    @Test
    public void testNamespaceProcess() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        int count = reader.loadBeanDefinitions("applicationContext.xml");

        Person person = (Person) factory.getBean("person");
        Assertions.assertThat(person.getName()).isEqualTo("Jacky");
    }
}
