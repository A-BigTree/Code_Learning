package com.seu.learn.inheritance;

public class Test {
    public static void main(String args){

        a t = new b();

        System.out.println(t instanceof a);
        System.out.println(t instanceof b);
        System.out.println(t instanceof c);
    }

}

class a{

}

class b extends a{

}

class c extends b{

}
