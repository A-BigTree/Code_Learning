/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.io
 * =====================================================
 * Title: FileTest.java
 * Created: [2022/11/1 14:31] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/11/1, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.io;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {

    @Test
    public void test1() {
        FileReader fr = null;
        try {
            // 实例化 File 对象，指明要操作的文件
            File file = new File("hello.txt");// 相较于当前的 Module
            // 2. 提供具体的流
            fr = new FileReader(file);
            // 3. 数据的读入过程
            // read():返回读入的一个字符。如果达到文件末尾，返回-1.
            // 方式一：
            // int data = fr.read();
            // while (data != -1) {
            // System.out.print((char) data);
            // data = fr.read();
            // }
            // 方式二：语法上针对于方式一的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流的关闭操作
            // try {
            // if (fr != null)
            // fr.close();
            // } catch (IOException e) {
            // e.printStackTrace();
            // }
            // 或
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 对 read() 操作升级：使用 read 的重载方法
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            // 1.File 类的实例化
            File file = new File("hello.txt");
            // 2.FileReader 流的实例化
            fr = new FileReader(file);
            // 3. 读入的操作
            // read(char[] cbuf): 返回每次读入 cbuf 数组中的字符的个数。如果达到文件末尾，返回 -1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                // 方式一：
                // 错误的写法
                // for (int i = 0; i < cbuf.length; i++) {
                // System.out.print(cbuf[i]);
                // }
                // // 正确的写法
                // for (int i = 0; i < len; i++) {
                // System.out.print(cbuf[i]);
                // }
                // 方式二：
                // 错误的写法 , 对应着方式一的错误的写法
                // String str = new String(cbuf);
                // System.out.print(str);
                // 正确的写法
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                // 4. 资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        FileWriter fw = null;
        try {
            // 1. 提供 File 类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            // 2. 提供 FileWriter 的对象，用于数据的写出
            fw = new FileWriter(file, false);
            // 3. 写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流资源的关闭
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
