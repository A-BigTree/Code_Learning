/**
 * ==================================================
 * Project: springMVC_project
 * Package: ssm
 * =====================================================
 * Title: SSMTest.java
 * Created: [2023/4/8 18:15] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/8, created by Shuxin-Wang.
 * 2.
 */

package ssm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.User;
import ssm.mapper.UserMapper;
import ssm.service.api.UserService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-persist.xml")
@Slf4j
public class SSMTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.debug("connection = " + connection);
    }

    @Test
    public void testMybatis(){
        List<User> users = userMapper.selectAll();

        for(User user:users){
            log.debug(user.toString());
        }
    }

    @Test
    public void testTx(){
        List<User> users = userService.getAll();

        for(User user:users){
            log.debug(user.toString());
        }
    }

}
