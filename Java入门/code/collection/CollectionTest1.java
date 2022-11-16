/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.collection
 * =====================================================
 * Title: CollectionTest1.java
 * Created: [2022/10/22 20:42] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/10/22, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.collection;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionTest1 {

    @Test
    public void test() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);
        // Collections.reverse(list);
        // Collections.shuffle(list);
        // Collections.sort(list);
        // Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 123);
        System.out.println(list);
        System.out.println(frequency);
    }

    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        // 报异常：IndexOutOfBoundsException("Source does notfit in dest")
        // List dest = new ArrayList();
        // Collections.copy(dest,list);
        // 正确的：
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());// list.size();
        Collections.copy(dest, list);
        System.out.println(dest);
        // 返回的 list1 即为线程安全的 List
        List list1 = Collections.synchronizedList(list);
    }
}
