package com.ruirui.spring.beans;

public class MongoUserRepository implements UserRepository {
    @Override
    public String description() {
        return "User repository mongodb implementation";
    }
}
