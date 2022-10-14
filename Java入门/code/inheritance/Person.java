package com.seu.learn.inheritance;

public class Person {
    String name;
    int age;

    public void eat(){
        System.out.println(" 人，吃饭");
    }
    public void walk(){
        System.out.println(" 人，走路");
    }
}

class Woman extends Person {
    boolean isBeauty;

    public void goShopping(){
        System.out.println(" 女人喜欢购物");
    }
    public void eat(){
        System.out.println(" 女人少吃，为了减肥。");
    }
    public void walk(){
        System.out.println(" 女人，窈窕的走路。");
    }
}

class Man extends Person {
    boolean isSmoking;

    public void earnMoney(){
        System.out.println(" 男人负责工作养家");
    }
    public void eat() {
        System.out.println(" 男人多吃肉，长肌肉");
    }
    public void walk() {
        System.out.println(" 男人霸气的走路");
    }
}


class PersonTest {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Man man = new Man();
        man.eat();
        man.age = 25;
        man.earnMoney();

        // ************************************
        System.out.println("************************");
        // 对象的多态性，父类的引用指向子类的对象
        Person p2 = new Man();
        // Person p3 = new Woman();
        // 多态的使用: 当调用子父类同名同参数方法时，实际调用的是子类重写父类的方法--- 虚拟方法调用
        p2.eat();
        p2.walk();
        // p2.earnMoney();
        System.out.println("**************************");
        // 不能调用子类所特有的方法、属性，编译时，p2 是Person类型，

        p2.name = "Tom";
        // p2.isSmoking = true;
        // 有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法，但是由于变量声明
        // 为父类类型，导致编译时，只能调用父类中声明的属性和方法。子类的属性和方法不能调用。
        // 如何才能调用子类所特有的属性和方法？
        // 使用强制类型转换符，也可称为: 向下转型
        Man m1 = (Man) p2;
        m1.earnMoney();
        m1.isSmoking = true;
        // 使用强转时，可能出现ClassCastException 异常
        // Woman w1 = (Woman)p2;
        // w1.goShopping();

    /*
    * instanceof 关键字的使用
    * a instanceof A：判断对象a 是否是类A 的实例。如果是，
    返回true，如果不是，返回false;
    * 使用情境：为了避免在向下转型时出现ClassCastException
    异常，我们在进行向下转型之前，先进行instanceof 的判断, 一旦返回
    true, 就进行向下转型。如果返回false，不进行向下转型。
    * 如果a instanceof A 返回true, 则a instanceof B 也返回
    true。 其中类B 是类A 的父类。
    */
        if (p2 instanceof Woman) {
            Woman w1 = (Woman) p2;
            w1.goShopping();
            System.out.println("**********Woman*********");
        }
        if (p2 instanceof Man) {
            Man m2 = (Man) p2;
            m2.earnMoney();
            System.out.println("*********Man************");
        }

        if (p2 instanceof Person) {
            System.out.println("***********Person************");
        }
        if (p2 instanceof Object) {
            System.out.println("***********object************");
        }
        // 向下转型的常见问题
        // 练习
        // 问题1: 编译时通过，运行时不通过
        // 举例一
        // Person p3 = new Woman();
        // Man m3 = (Man)p3;
        // 举例二
        // Person p4 = new Person();
        // Man m4 = (Man)p4;

        // 问题二: 编译通过，运行时也通过
        Object obj = new Woman();
        Person p = (Person)obj;

        // 问题三: 编译不通过
        // Man m5 = new woman();
        // String str = new Date();
        // Object o = new Date();
        // String str1 = (String)o;
    }
}
