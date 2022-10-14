package com.seu.learn.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {
    public static void main(String[] args) {
        OverrideTest test = new OverrideTest();
        test.display(new SubClass());
    }

    public void display(SuperClass s) {
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SuperClass {
    public void method() throws IOException {
    }
}

class SubClass extends SuperClass {
    public void method() throws FileNotFoundException {
    }
}
