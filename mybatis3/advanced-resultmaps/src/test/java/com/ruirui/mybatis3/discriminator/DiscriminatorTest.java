package com.ruirui.mybatis3.discriminator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.sql.Connection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscriminatorTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        // create a SqlSessionFactory
        Reader reader = Resources.getResourceAsReader("com/ruirui/mybatis3/discriminator/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

        // populate in-memory database
        SqlSession session = sqlSessionFactory.openSession();
        Connection conn = session.getConnection();
        ScriptRunner runner = new ScriptRunner(conn);
        reader = Resources.getResourceAsReader("com/ruirui/mybatis3/discriminator/CreateDB.sql");
        runner.setLogWriter(null);
        runner.runScript(reader);
        reader.close();
        session.close();
    }

    @Test
    public void testDiscriminator() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonRepository mapper = sqlSession.getMapper(PersonRepository.class);
            List<Person> list = mapper.findAllPersons();
            assertThat(list.size()).isEqualTo(4);

            assertThat(list.get(0).getType()).isEqualTo("SALE");
            assertThat(list.get(0)).isInstanceOf(Salesman.class);
            assertThat(((Salesman)list.get(0)).getCustomers().size()).isEqualTo(2);
            assertThat(((Customer)((Salesman)list.get(0)).getCustomers().get(0)).getSalesman()).isInstanceOf(Salesman.class); // 这里有深递归查询

            assertThat(list.get(2).getType()).isEqualTo("CUSTOMER");
            assertThat(list.get(2)).isInstanceOf(Customer.class);
            assertThat(((Customer)list.get(2)).getSalesman().getId()).isEqualTo(1);

            assertThat(list.get(1)).isInstanceOf(Salesman.class);
            assertThat(((Salesman)list.get(1)).getCustomers().size()).isEqualTo(0);
        } finally {
            sqlSession.close();
        }
    }
}
