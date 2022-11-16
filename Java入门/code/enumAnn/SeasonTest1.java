/**
 * ==================================================
 * Project: test1
 * Package: com.seu.learn.enumAnn
 * =====================================================
 * Title: SeasonTest1.java
 * Created: [2022/9/24 19:20] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2022/9/24, created by Shuxin-Wang.
 * 2.
 */

package com.seu.learn.enumAnn;

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        // toString():
        System.out.println(summer.toString());
        System.out.println(Season1.class.getSuperclass());
        System.out.println("**************************");
        // values(): 返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }
        System.out.println("****************************");
        Thread.State[] values1 = Thread.State.values();
        for (Thread.State state : values1) {
            System.out.println(state);
        }
        // valueOf(String objName): 返回枚举类中对象名是 objName的对象。
        Season1 winter = Season1.valueOf("WINTER");
        // 如果没有 objName 的枚举类对象，则抛异常：IllegalArgumentException
        // Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
    }
}

// 使用 enum 关键字枚举类
enum Season1 {
    // 1. 提供当前枚举类的对象，多个对象之间用 "," 隔开，末尾对象 ";"结束
    SPRING(" 春 天 ", " 万 物 复 苏 "),
    SUMMER(" 夏 天 ", " 烈 日 炎 炎 "),
    AUTUMN(" 秋天 ", " 金秋送爽 "),
    WINTER(" 冬天 ", " 白雪皑皑 ");
    // 2. 声明 Season 对象的属性 :private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 3. 私有化类的构造器 , 并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4. 其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    // 4. 其他诉求 1：提供 toString()
    // @Override
    // public String toString() {
    // return "Season{" + "seasonName='" + seasonName + '\'' +", seasonDesc='" + seasonDesc + '\'' + '}';
    // }
}
