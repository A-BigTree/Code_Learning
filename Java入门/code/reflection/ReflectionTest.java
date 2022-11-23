/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.reflection
 * =====================================================
 * Title: ReflectionTest.java
 * Created: [2022/11/17 22:10] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/11/17, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.reflection;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    // 反射之前，对于 Person 的操作
    @Test
    public void test() {
        // 1. 创建类的对象
        Person p1 = new Person("jay", 21);
        // 2. 调用对象 , 调用其内部的属性和方法
        p1.age = 15;
        System.out.println(p1.toString());
        p1.show();
        // 在 Person 类的外部，不可以通过 Person 类的对象调用其内部私有的结构。
        // 比如：name、showNation 以及私有的构造器。
    }

    // 反射之后 ，堆与 Person 的操作
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        // 1. 通过反射，创建 Person 类的对象
        Constructor cons = clazz.getConstructor(String.class, int.
                class);
        Object obj = cons.newInstance("Jon", 18);
        Person p = (Person) obj;
        System.out.println(p.toString());
        // 2. 通过反射，调用对象指定的属性和方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());
        // 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("+++++++++++++++++++++++");
        // 通过反射，是可以调用 Person 类的私有结构的。比如：私有的构造器、方法、属性
        // 调用私有的构造器
        Constructor cons2 = clazz.getDeclaredConstructor(String.class);
        cons2.setAccessible(true);
        Person p1 = (Person) cons2.newInstance("kalo");
        System.out.println(p1);
        // 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Taoyao");
        System.out.println(p1);
        // 调用私有的方法
        Method showNation = clazz.getDeclaredMethod("LiNin",
                String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "FaceBook");
        // 相当于 String nation = p1.showNation("FaceBook")
        System.out.println(nation);
    }
}
