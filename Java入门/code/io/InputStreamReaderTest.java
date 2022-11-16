/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.io
 * =====================================================
 * Title: InputSreamReaderTest.java
 * Created: [2022/11/1 16:43] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/11/1, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.io;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    // 此时处理异常的话，仍然应该使用 try-catch-finally InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
    @Test
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("dbcp.txt");
        // InputStreamReader isr = new InputStreamReader(fis);
        // 使用系统默认的字符集
        // 参数 2 指明了字符集，具体使用哪个字符集，取决于文件 dbcp.txt 保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // 使用系统默认的字符集
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }
        isr.close();
    }
}
