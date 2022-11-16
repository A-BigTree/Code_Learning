/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.io
 * =====================================================
 * Title: FileIOTest.java
 * Created: [2022/11/1 15:03] by Shuxin-Wang
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

public class FileIOTest {
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1. 造文件
            File srcFile = new File(" 爱情与友情.jpg");
            File destFile = new File(" 爱情与友情2.jpg");
            // 2. 造流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 3. 复制的过程
            byte[] buffer = new byte[5];
            int len;
            // 4. 读数据
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println(" 复制成功 ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                // 5. 关闭资源
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
