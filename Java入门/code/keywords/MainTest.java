package com.seu.learn.keywords;

public class MainTest {
    public static void main(String[] args) { // 入口
        Main.main(new String[100]);
        MainTest test = new MainTest();
        test.show();
    }
    public void show(){
    }
}
class Main{
    public static void main(String[] args) {
        args = new String[100];
        for(int i = 0;i < args.length;i++){
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
    }
}
