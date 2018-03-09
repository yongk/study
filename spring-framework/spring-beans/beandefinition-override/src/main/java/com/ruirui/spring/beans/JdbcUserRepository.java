package com.ruirui.spring.beans;

public class JdbcUserRepository implements UserRepository {
    @Override
    public String description() {
        return "User repository jdbc implementation";
    }
}
