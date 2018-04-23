package com.ruirui.spring.aop.autoproxy;

import com.google.common.collect.Lists;

import java.util.List;

public class PersonManagerImpl implements PersonManager {
    @Override
    public List<Person> findAll() {
        Person person = new Person();
        person.setId(1);
        person.setName("Jacky");
        person.setAge(11);
        return Lists.newArrayList(person);
    }
}
