package com.seu.learn.project.teamwork.service;

public class TeamException extends RuntimeException {
    static final long serialVersionUID = -7034897193246939L;

    public TeamException() {
        super();
    }

    public TeamException(String msg){
        super(msg);
    }

}
