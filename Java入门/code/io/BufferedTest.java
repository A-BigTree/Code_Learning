/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.io
 * =====================================================
 * Title: BufferedTest.java
 * Created: [2022/11/1 15:58] by Shuxin-Wang
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

public class BufferedTest {
    // 实现非文本文件的复制
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File srcFile = new File(" 爱情与友情 .jpg");
            File destFile = new File(" 爱情与友情 3.jpg");
            // 2. 造流
            // 2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new
                    FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 3. 复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            //bos.flush();// 刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源关闭
            // 要求：先关闭外层的流，再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 说明：关闭外层流的同时，内层流也会自动进行关闭。关于内层流的关闭，我们可以省略.
            // fos.close();
            // fis.close();
        }
    }
}
