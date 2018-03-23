package com.ruirui.mybatis3.collection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 对ResultMap中的<collection/>测试。
 */
public class ResultMapWithCollectionTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        // create a SqlSessionFactory
        Reader reader = Resources.getResourceAsReader("com/ruirui/mybatis3/collection/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

        // populate in-memory database
        SqlSession session = sqlSessionFactory.openSession();
        Connection conn = session.getConnection();
        ScriptRunner runner = new ScriptRunner(conn);
        reader = Resources.getResourceAsReader("com/ruirui/mybatis3/collection/CreateDB.sql");
        runner.setLogWriter(null);
        runner.runScript(reader);
        reader.close();
        session.close();
    }

    /**
     * 测试NestedResult。
     * <br>
     * note：<collection>中的notNullColumn效果等同于<association>中的notNullColumn。
     */
    @Test
    public void testNestedResults() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserRepository mapper = sqlSession.getMapper(UserRepository.class);
            List<User> userList = mapper.findAll();
            assertThat(userList.size()).isEqualTo(2); // 实际sql语句查出了3条记录，其中一个user对应两个role合并成了一个user,使用分页插件时注意
            assertThat(userList.get(0).getRoles().size()).isEqualTo(2);
            assertThat(userList.get(1).getRoles().size()).isEqualTo(1);

            assertThat(userList).isInstanceOf(ArrayList.class);
            assertThat(userList.get(0).getRoles()).isInstanceOf(ArrayList.class);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testNestedSelect() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserRepository mapper = sqlSession.getMapper(UserRepository.class);
            List<User> userList = mapper.findAllNestedSelect(); // N+1次查询
            assertThat(userList.size()).isEqualTo(2); // list大小是2，所以查询了2+1=3次数据库
            assertThat(userList.get(0).getRoles().size()).isEqualTo(2);
            assertThat(userList.get(1).getRoles().size()).isEqualTo(1);

            assertThat(userList).isInstanceOf(ArrayList.class);
            assertThat(userList.get(0).getRoles()).isInstanceOf(ArrayList.class);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testFindRolesByUsername() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserRepository mapper = sqlSession.getMapper(UserRepository.class);
            List<Role> roleList = mapper.findRolesByUsername("lucy");
            assertThat(roleList.size()).isEqualTo(1);
        } finally {
            sqlSession.close();
        }
    }
}
