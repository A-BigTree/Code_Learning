/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.io
 * =====================================================
 * Title: OtherStreamTest.java
 * Created: [2022/11/1 17:36] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/11/1, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.io;

import org.testng.annotations.Test;

import java.io.*;

public class OtherStreamTest {
    @Test
    public void test() {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println(" 请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".
                        equalsIgnoreCase(data)) {
                    System.out.println(" 程序结束 ");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            // 创建打印输出流 , 设置为自动刷新模式 ( 写入换行符或字节 '\n' 时都会刷新输出缓冲区 )
            ps = new PrintStream(fos, true);
            // 把标准输出流 ( 控制台输出 ) 改成文件
            System.setOut(ps);
            for (int i = 0; i <= 255; i++) { // 输出 ASCII 字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每 50 个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    @Test
    public void test3() throws IOException {
        // 1.
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        // 2.
        dos.writeUTF(" 刘刚 ");
        dos.flush(); // 刷新操作，将内存中的数据写入文件
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();
        // 3.
        dos.close();
    }

    // 将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。
    // 注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
    @Test
    public void test4() throws IOException {
        // 1.
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        // 2.
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("isMale = " + isMale);
        // 3.
        dis.close();
    }
}
