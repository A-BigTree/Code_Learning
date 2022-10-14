package com.seu.learn.project.teamwork.domain;

public class Designer extends Programmer {
    private double bonus;// 奖金

    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t 设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getTeamBaseDetails() + "\t 设计师\t" + getBonus();
    }

    @Override
    public String getWork(){
        return "设计师";
    }
}
