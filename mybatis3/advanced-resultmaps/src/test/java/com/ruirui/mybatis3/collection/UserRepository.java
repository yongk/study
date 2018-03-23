package com.ruirui.mybatis3.collection;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    List<User> findAllNestedSelect();

    List<Role> findRolesByUsername(String username);
}
