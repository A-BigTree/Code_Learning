package com.seu.learn.project.teamwork.domain;

public class PC implements Equipment {

    private String model;  //电脑型号
    private String display;  //显示器配置

    public PC() {
        super();
    }

    public PC(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getModel() {
        return this.model;
    }

    public String getDisplay() {
        return this.display;
    }


    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
