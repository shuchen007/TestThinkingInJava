package com.hao.class14;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/29.
 */
class A extends B {
    static {
        System.out.println(".A");
    }
}
class B{
    static{
        System.out.println("B");
    }
    public String x(){return  "xx";}
}
public class TestReflect {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        new A();
        try {
            //通过泛型新建对象。Class.forName()和A.class.h
            Class<A> a = A.class;
//            Class<A> a = Class.forName("com.hao.class14.A");
            System.out.println("do="+a.getName());
            A b= a.newInstance();
            System.out.println("do="+b.x());

            Class c = Class.forName("com.hao.class14.A");
            try {
                Object obj = c.getSuperclass().newInstance();
                Class c1 = obj.getClass();
                System.out.println(Arrays.toString(c1.getDeclaredMethods()));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(c.getSuperclass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
