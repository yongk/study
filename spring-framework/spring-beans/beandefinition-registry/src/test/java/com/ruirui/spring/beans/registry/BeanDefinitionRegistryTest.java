package com.ruirui.spring.beans.registry;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanDefinitionRegistryTest {
    static DefaultListableBeanFactory factory;

    @BeforeClass
    public static void setUp() {
        factory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        int count = reader.loadBeanDefinitions("/context.xml");

        RootBeanDefinition userServiceImpl = new RootBeanDefinition(UserServiceImpl.class);
        userServiceImpl.setSource(null);
        userServiceImpl.getPropertyValues().addPropertyValue("userRepository", factory.getBeanDefinition("userRepository"));
        factory.registerBeanDefinition("userServiceImpl", userServiceImpl);
    }

    @Test
    public void testAutowireIsOk() {
        Object userServiceImpl = factory.getBean("userServiceImpl");
        assertThat(userServiceImpl).isInstanceOf(UserServiceImpl.class);

        UserService userService = (UserService) userServiceImpl;
        UserEntity userEntity = userService.selectUserById(1);
        assertThat(userEntity.getName()).isEqualTo("Jacky");
    }
}
