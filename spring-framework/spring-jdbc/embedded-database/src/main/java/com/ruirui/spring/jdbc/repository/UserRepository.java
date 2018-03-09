package com.ruirui.spring.jdbc.repository;

import com.ruirui.spring.jdbc.model.User;

public interface UserRepository {
    User getUserById(Long id);
}
