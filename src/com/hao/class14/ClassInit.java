package com.hao.class14;

/**
 * Created by sunhao on 2018/3/12.
 *
 * @描述
 */
public class ClassInit {
    public static void main(String[] args) {
// TODO Auto-generated method stub   
        new B1();
    }
}

class A1 {
    static {
        System.out.println("A的static代码块...");
    }

    public String s1 = prtString("A的成员变量...");
    public static String s2 = prtString("A的static变量...");

    public A1() {
        System.out.println("A的构造函数...");
    }


    public static String prtString(String str) {
        System.out.println(str);
        return null;
    }
}

class B1 extends A1 {
    public String ss1 = prtString("B的成员变量...");
    public static String ss2 = prtString("B的static变量...");

    public B1() {
        System.out.println("B的构造函数...");
    }

    private static A1 a = new A1();

    static {
        System.out.println("B的static代码块...");
    }


    {
        System.out.println("代码块...");
    }

}
