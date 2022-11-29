/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.reflection
 * =====================================================
 * Title: MythodTest.java
 * Created: [2022/11/29 15:23] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/11/29, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.reflection;

import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    @Test
    public void test() {
        Class clazz = Person.class;
        // getMethods(): 获取当前运行时类及其所有父类中声明为public 权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m + "****");
        }
        System.out.println("++++++++++++++++++++++++");
        // getDeclaredMethods(): 获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    // 权限修饰符 返回值类型 方法名 ( 参数类型 1 形参名 1,...) throws XxxException{}
    @Test
    public void test2() {
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            // 1. 获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos) {
                System.out.println(a + "KKKK");
            }
            // 2. 权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            // 3. 返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
            // 4. 方法名
            System.out.print(m.getName());
            System.out.print("(");
            // 5. 形参列表
            Class[] pTs = m.getParameterTypes();
            if (!(pTs == null && pTs.length == 0)) {
                for (int i = 0; i < pTs.length; i++) {
                    if (i == pTs.length - 1) {
                        System.out.print(pTs[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(pTs[i].getName() + " args_"
                            + i + ",");
                }
            }
            System.out.print(")");
            // 6. 抛出的异常
            Class[] eTs = m.getExceptionTypes();
            if (eTs.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < eTs.length; i++) {
                    if (i == eTs.length - 1) {
                        System.out.print(eTs[i].getName());
                        break;
                    }
                    System.out.print(eTs[i].getName() + ",");
                }
            }
            System.out.println("TQA");
        }
    }
}
