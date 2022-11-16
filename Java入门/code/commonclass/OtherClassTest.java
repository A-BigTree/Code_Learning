/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.commonclass
 * =====================================================
 * Title: OtherClassTest.java
 * Created: [2022/9/6 17:16] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/9/6, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.commonclass;

import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class OtherClassTest {
    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java 的 version:" + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java 的 home:" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os 的 name:" + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os 的 version:" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user 的 name:" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user 的 home:" + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user 的 dir:" + userDir);
    }

    @Test
    public void test2() {
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, RoundingMode.HALF_UP));
        System.out.println(bd.divide(bd2, 25, RoundingMode.HALF_UP));
    }

}
