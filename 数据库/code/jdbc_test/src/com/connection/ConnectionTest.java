/**
 * ==================================================
 * Project: jdbc_test
 * Package: com.connection
 * =====================================================
 * Title: ConnectionTest1.java
 * Created: [2023/3/14 0:00] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/3/14, created by Shuxin-Wang.
 * 2.
 */

package com.connection;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class ConnectionTest {
    @Test
    public void testConnection2() {
        try {
            //1.实例化Driver
            String className = "com.mysql.cj.jdbc.Driver";
            Class<?> clazz = Class.forName(className);
            Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

            //2.提供url，指明具体操作的数据
            String url = "jdbc:mysql://localhost:3306/mysql";

            //3.提供Properties的对象，指明用户名和密码
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "020312");

            //4.调用driver的connect()，获取连接
            Connection conn = driver.connect(url, info);
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
