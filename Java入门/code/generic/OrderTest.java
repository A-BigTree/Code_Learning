/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.generic
 * =====================================================
 * Title: OrderTest.java
 * Created: [2022/10/22 21:19] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/10/22, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderTest<T> {
    String orderName;
    int orderId;
    // 类的内部结构就可以使用类的泛型
    T orderT;

    public OrderTest() {
    }

    public OrderTest(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    // 如下的三个方法都不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" + "orderName='" + orderName + '\'' + ", orderId=" + orderId + ", orderT=" + orderT + '}';
    }

    // 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    // 换句话说，泛型方法所属的类是不是泛型类都没有关系。
    // 泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        Collections.addAll(list, arr);
        return list;
    }
}
