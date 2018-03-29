package com.hao.class14;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */
public class Son extends Father {
    //    private static Son son = new Son();
    public String ss;

    static {
        System.out.println("初始化son");
    }

    Son() {
        super("d");//Java的规定：子类继承父类，子类的构造方法必须调用super（）即父类的构造方法，而且必须放在构造方法的第一行。

    }

    public Son(String x) {
        super("df");
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("2");
        for (Object x : list) {
            System.out.println(x.toString());
        }
        System.out.println("1");
    }

    String do2() {
        System.out.println("do son2!");
        return "doxx";
    }

    public String do3() {
        System.out.println("do son3!");
        return "doxx";
    }

    public void do4() {
        System.out.println("do son!");
    }

    public void do5(String x) {
        System.out.println("do so=!" + x);
    }

    public void do5(int x) {
        System.out.println("do so=!" + x);
    }

}