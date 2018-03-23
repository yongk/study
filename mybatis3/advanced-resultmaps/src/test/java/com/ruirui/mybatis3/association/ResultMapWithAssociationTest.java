package com.ruirui.mybatis3.association;

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

/**
 * 对ResultMap中的<association/>测试。
 */
public class ResultMapWithAssociationTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        // create a SqlSessionFactory
        Reader reader = Resources.getResourceAsReader("com/ruirui/mybatis3/association/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

        // populate in-memory database
        SqlSession session = sqlSessionFactory.openSession();
        Connection conn = session.getConnection();
        reader = Resources.getResourceAsReader("com/ruirui/mybatis3/association/CreateDB.sql");
        ScriptRunner runner = new ScriptRunner(conn);
        runner.setLogWriter(null);
        runner.runScript(reader);
        reader.close();
        session.close();
    }

    @Test
    public void testNestedResults() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BlogRepository mapper = sqlSession.getMapper(BlogRepository.class);
            List<Blog> resultList = mapper.findAllNestedResult();
            assertThat(resultList.size()).isEqualTo(2);
            assertThat(resultList.get(0).getAuthor()).isNotNull();
            assertThat(resultList.get(1).getAuthor().getUsername()).isNull();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 测试notNullColumn属性作用。
     * <br> 在指定notNullColumn后，只要任意一个指定的列不为null，对象就会被构建，否则对象不会被创建尽管其他列不为null。多个列用','分隔。
     * <br> 在未指定notNullColumn的情况下，只要映射到对象属性的列中任意一个不为null，对象就会被创建。
     */
    @Test
    public void testNestedResultsApplyNotNullColumn() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BlogRepository mapper = sqlSession.getMapper(BlogRepository.class);
            List<Blog> resultList = mapper.findAllNestedResultApplyNotNullColumn();
            assertThat(resultList.size()).isEqualTo(2);
            assertThat(resultList.get(0).getAuthor()).isNotNull();
            assertThat(resultList.get(1).getAuthor()).isNull(); // username_是null,所以不构建这个Author对象了，尽管id_非null
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testNestedSelectEager() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Blog result;
        try {
            BlogRepository mapper = sqlSession.getMapper(BlogRepository.class);
            result = mapper.selectBlogByIdEager(1);
            assertThat(result).isNotNull();
            assertThat(result.getAuthor()).isNotNull();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testNestedSelectLazy() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Blog result;
        try {
            BlogRepository mapper = sqlSession.getMapper(BlogRepository.class);
            result = mapper.selectBlogByIdLazy(1);
            assertThat(result).isNotNull();
        } finally {
            sqlSession.close();
        }
        assertThat(result.getAuthor()).isNotNull();
    }


    /**
     * 测试返回的List中的对象是NestedSelectEager也是工作的。
     */
    @Test
    public void testListNestedSelectEager() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Blog> result;
        try {
            BlogRepository mapper = sqlSession.getMapper(BlogRepository.class);
            result = mapper.selectBlogsEager();
            assertThat(result.size()).isEqualTo(2);
            assertThat(result.get(0)).isNotNull();
            assertThat(result.get(1)).isNotNull();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 测试返回的List中的对象是NestedSelectLazy也是工作的。
     */
    @Test
    public void testListNestedSelectLazy() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Blog> result;
        try {
            BlogRepository mapper = sqlSession.getMapper(BlogRepository.class);
            result = mapper.selectBlogsLazy();
            assertThat(result.size()).isEqualTo(2);
        } finally {
            sqlSession.close();
        }
        assertThat(result.get(0)).isNotNull();
        assertThat(result.get(1)).isNotNull();
    }
}
