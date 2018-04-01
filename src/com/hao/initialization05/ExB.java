package com.hao.initialization05;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

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
 class TestStaticSort {
    static {
        System.out.println("父类--静态代码块");
    }

    public TestStaticSort() {
        System.out.println("父类--构造函数");
    }
     //调用方法实现栈溢出。
    void do2(){
        do2();
    };
    {
        System.out.println("父类--非静态代码块");
    }
    public static void main(String[] args) {
        ExB exB = new ExB();
        System.out.println(exB.x1());
        System.out.println(exB.b);
        System.out.println(ExB.x2());
        System.out.println(ExB.a);
//        List<String> list = new ArrayList<String>();
        //测试堆溢出和栈溢出。
//        while (true){
//            new TestStaticSort().do2();
//        }
    }
}
/*父类--静态代码块
子类--静态代码块
父类--非静态代码块
父类--构造函数
子类--非静态代码块
子类--构造函数
普通方法
null
2
静态方法
null
1

初始化父类成员变量（我们常说的赋值语句），普通代码块。
初始化父类构造函数
初始化子类成员变量，普通代码块。
初始化子类构造函数
*/
