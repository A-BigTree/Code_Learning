package com.seu.learn.exception;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest1 {
    @Test
    public void test2() {
        try {
            File file = new File("hello.txt");
            FileInputStream fis = new FileInputStream(file);
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        String str = "123";
        str = "abc";
        try {
            int num = Integer.parseInt(str);
            System.out.println("hello-----1");
        } catch (NumberFormatException e) {
            // System.out.println(" 出现数值转换异常了，不要着急....");
            //String getMessage():
            // System.out.println(e.getMessage());
            //printStackTrace():
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println(" 出现空指针异常了，不要着急....");
        } catch (Exception e) {
            System.out.println(" 出现异常了，不要着急....");
        }
        // System.out.println(num);
        System.out.println("hello----2");
    }
}