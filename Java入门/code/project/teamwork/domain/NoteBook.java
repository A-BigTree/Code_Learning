package com.seu.learn.project.teamwork.domain;

public class NoteBook implements Equipment {

    private String model;
    private double price;

    public NoteBook() {
        super();
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
