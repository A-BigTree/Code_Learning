/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.reflection
 * =====================================================
 * Title: Creature.java
 * Created: [2022/11/29 15:12] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/11/29, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.reflection;

import java.io.Serializable;

public abstract class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println(" 太阳系 ");
    }
    public void eat() {
        System.out.println(" 银河系 ");
    }
}
