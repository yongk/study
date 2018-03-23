package com.ruirui.mybatis3.discriminator;

import java.util.List;

public interface PersonRepository {
    List<Person> findAllPersons();
}
