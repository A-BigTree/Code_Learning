/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.internetCode
 * =====================================================
 * Title: URLTest.java
 * Created: [2022/11/15 17:30] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/11/15, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.internetCode;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://127.0.0.1:8080/work/164.jpg?username=subei");
            // public String getProtocol( ) 获取该 URL 的协议名
            System.out.println(url.getProtocol());
            // public String getHost( ) 获取该 URL 的主机名
            System.out.println(url.getHost());
            // public String getPort( ) 获取该 URL 的端口号
            System.out.println(url.getPort());
            // public String getPath( ) 获取该 URL 的文件路径
            System.out.println(url.getPath());
            // public String getFile( ) 获取该 URL 的文件名
            System.out.println(url.getFile());
            // public String getQuery( ) 获取该 URL 的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
