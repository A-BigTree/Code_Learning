package cn.seucs.mybatis;

import static org.junit.Assert.assertTrue;

import cn.seucs.mybatis.beans.User;
import cn.seucs.mybatis.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    private SqlSession session;

    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    }

    @After
    public void clear(){
        session.commit();
        session.close();
    }

    /*
    @Test
    public void testSelectUser() throws IOException {
        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession();

        // 3.根据Mapper配置文件的名称空间+SQL语句的id找到具体的SQL语句
        // 格式是：名称空间.SQL语句的id
        String statement = "cn.seucs.mybatis.dao.UserMapper.selectUser";

        // 要传入SQL语句的参数
        String userId = "000000";

        // 执行SQL语句
        Object result = session.selectOne(statement, userId);

        if (result != null) {
            log.info(result.toString());
        }

        // 4.关闭SqlSession
        session.close();
    }*/

    @Test
    public void testUserMapper(){
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = userMapper.selectUser("000000");
        if(user!=null)
            log.info(user.toString());
    }
}
