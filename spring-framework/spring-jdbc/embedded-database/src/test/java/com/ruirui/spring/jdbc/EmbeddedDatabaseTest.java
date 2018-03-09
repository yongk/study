package com.ruirui.spring.jdbc;

import com.ruirui.spring.jdbc.model.User;
import com.ruirui.spring.jdbc.repository.UserRepository;
import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EmbeddedDatabaseConfig.class, EmbeddedDatabaseTest.Config.class})
public class EmbeddedDatabaseTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserExist() {
        User user = userRepository.getUserById(1L);
        assertThat(user).isNotNull();
//        showDatabaseManager();
    }

    void showDatabaseManager() {
        System.setProperty("java.awt.headless", "false");
        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false;MODE=PostgreSQL", "--user", "sa", "--password", "" });
    }

    @Configuration
    static class Config {
        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .addScript("classpath:schema-h2.sql")
                    .addScript("classpath:data-h2.sql")
                    .build();
        }
    }
}
