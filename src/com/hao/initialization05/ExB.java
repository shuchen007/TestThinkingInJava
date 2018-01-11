package com.hao.initialization05;

/**
 * Created by Administrator on 2017/8/27.
 */
public class ExB extends TestStaticSort {
    public static final int a = 1;
    int b= 2;
    static {
        System.out.println("子类--静态代码块");
    }

    {
        System.out.println("子类--非静态代码块");
    }

    public ExB() {
        System.out.println("子类--构造函数");
    }
    public static String  x2(){
         int ad =2;
        System.out.println("静态方法");
        return null;
    }
    public  String  x1(){
        int ad =1;
        System.out.println("普通方法");
        return null;
    }
}
