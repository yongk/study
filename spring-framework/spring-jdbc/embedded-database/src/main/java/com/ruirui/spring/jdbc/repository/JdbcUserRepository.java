package com.ruirui.spring.jdbc.repository;

import com.ruirui.spring.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JdbcUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id, name, age FROM user", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong(1));
            user.setName(rs.getString(2));
            user.setAge(rs.getInt(3));
            return user;
        });
    }
}
