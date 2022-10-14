package com.seu.learn.project.teamwork.domain;

public class Architect extends Designer {
    private int stock;// 股票

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary,
                     Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t 架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam() {
        return getTeamBaseDetails() + "\t 架构师\t" + getBonus() + "\t" + getStock();
    }

    @Override
    public String getWork() {
        return "架构师";
    }
}