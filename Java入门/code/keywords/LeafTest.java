package com.seu.learn.keywords;

public class LeafTest {
    public static void main(String[] args) {
        new Leaf();
        //new Leaf();
    }
}

class Root {
    static {
        System.out.println("Root 的静态初始化块");
    }

    {
        System.out.println("Root 的普通初始化块");
    }

    public Root() {
        System.out.println("Root 的无参数的构造器");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid 的静态初始化块");
    }

    {
        System.out.println("Mid 的普通初始化块");
    }

    public Mid() {
        System.out.println("Mid 的无参数的构造器");
    }

    public Mid(String msg) {
        // 通过 this 调用同一类中重载的构造器
        this();
        System.out.println("Mid 的带参数构造器，其参数值："
                + msg);
    }
}

class Leaf extends Mid {
    static {
        System.out.println("Leaf 的静态初始化块");
    }

    {
        System.out.println("Leaf 的普通初始化块");
    }

    public Leaf() {
        // 通过 super 调用父类中有一个字符串参数的构造器
        super(" 尚硅谷");
        System.out.println("Leaf 的构造器");
    }
}
