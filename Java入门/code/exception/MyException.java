package com.seu.learn.exception;

public class MyException extends RuntimeException {
    static final long serialVersionUID = -7034897193246939L;

    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}
