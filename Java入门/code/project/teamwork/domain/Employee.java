package com.seu.learn.project.teamwork.domain;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getDetails() {
        return id + "\t" + name + "\t" + age + "\t" + salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }

    public String getWork(){
        return "非开发人员";
    }
}
