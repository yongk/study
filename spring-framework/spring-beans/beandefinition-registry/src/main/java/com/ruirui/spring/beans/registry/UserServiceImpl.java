package com.ruirui.spring.beans.registry;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserEntity selectUserById(Integer id) {
        return userRepository.selectUserById(id);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
