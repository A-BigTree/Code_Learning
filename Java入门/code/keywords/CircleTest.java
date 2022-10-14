package com.seu.learn.keywords;

//static 关键字的应用
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle();
        System.out.println("c1 的 ID:" + c1.getId());
        System.out.println("c2 的 ID:" + c2.getId());
        System.out.println("c3 的 ID:" + c3.getId());
        System.out.println(" 创建圆的个数: " + Circle.getTotal());
    }
}

class Circle {
    private double radius;
    private int id; // 需要自动赋值

    public Circle() {
        id = init++;
        total++;
    }

    public Circle(double radius) {
        this();
        //或
        // id = init++;
        // total++;
        this.radius = radius;
    }

    private static int total;// 记录创建圆的个数
    private static int init = 1001;//static 声明的属性被所有对象所共享

    public double findArea() {
        return 3.14 * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }
}