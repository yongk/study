package com.ruirui.spring.aop.autoproxy;

import com.google.common.collect.Lists;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class PersonManagerTransactionImpl implements PersonManager {

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        Person person = new Person();
        person.setId(1);
        person.setName("Jacky");
        person.setAge(11);
        return Lists.newArrayList(person);
    }
}
