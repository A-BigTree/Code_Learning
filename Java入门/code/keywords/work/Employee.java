package com.seu.learn.keywords.work;

public abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

}

class Manager extends Employee {

    private double bonus; //奖金

    public Manager() {
        super();
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理员工，提高公司效率。");
    }
}

class CommonEmployee extends Employee {

    @Override
    public void work() {
        System.out.println("员工在一线车间生产产品");
    }
}