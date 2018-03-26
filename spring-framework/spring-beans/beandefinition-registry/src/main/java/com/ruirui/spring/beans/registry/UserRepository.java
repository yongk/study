package com.ruirui.spring.beans.registry;

public class UserRepository {
    public UserEntity selectUserById(Integer id) {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("Jacky");
        return user;
    }
}
