/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.generic
 * =====================================================
 * Title: GenericTest.java
 * Created: [2022/10/22 21:09] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/10/22, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.generic;

import org.testng.annotations.Test;

import java.util.*;

public class GenericTest {

    // 在集合中使用泛型的情况：以 HashMap 为例
    @Test
    public void test3() {
        // Map<String,Integer> map = new HashMap<String,Integer> ();
        // jdk7 新特性：类型推断
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 87);
        map.put("Tone", 81);
        map.put("Jack", 64);
        // map.put(123,"ABC");
        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        for (Map.Entry<String, Integer> e : entry) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----" + value);
        }
    }

    // 在集合中使用泛型的情况：以 ArrayList 为例
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(49);
        list.add(72);
        list.add(81);
        list.add(89);
        // 编译时，就会进行类型检查，保证数据的安全
        // list.add("Tom");
        // 方式一：
        // for(Integer score :list){
        // 避免了强转的操作
        // int stuScore = score;
        //
        // System.out.println(stuScore);
        // }
        // 方式二：
        for (int stuScore : list) {
            System.out.println(stuScore);
        }
    }
}
