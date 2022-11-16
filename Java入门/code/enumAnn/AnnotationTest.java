/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.enumAnn
 * =====================================================
 * Title: AnnotationTest.java
 * Created: [2022/9/24 19:36] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/9/24, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.enumAnn;

import org.testng.annotations.Test;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

public class AnnotationTest {
    @Test
    public void testGetAnnotation() {
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

@MyAnnotation(value = "hello")
class Person {
    private String name;
    private int age;

    public Person() {
        super();
    }

    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    public void walk() {
        System.out.println(" 学习中……");
    }

    public void eat() {
        System.out.println(" 摸鱼中……");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println(" 喷子走开 ");
    }

    @Override
    public void show() {
    }
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR,
        LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
@interface MyAnnotation {
    String value() default "book";
}