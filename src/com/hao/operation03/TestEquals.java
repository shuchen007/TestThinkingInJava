package com.hao.operation03;

/**
 * Created by Administrator on 2017/8/26.
 */
public class TestEquals {
    public static void main(String[] args) {
        int a = 3 ,b = 4 ,c = a ;
        System.out.println((a==c)+"  "+(a==b));

        Apple apple1 = new Apple();
        apple1.i = 1 ;
        Apple apple2 = new Apple();
        apple2= apple1 ;
        System.out.println(apple1 ==apple2);
        System.out.println((apple1).equals(apple2));

        String x = new String("d");
        String y = new String("d");
        System.out.println(x==y);
        System.out.println(x.equals(y));

        Float f1 = 23.1f;
        Double d1 = 21.5d;
        System.out.println(Math.round(f1)+""+Math.round(d1));
        System.out.println(Math.floor(f1)+""+Math.floor(d1));
        System.out.println(Math.ceil(f1)+""+Math.ceil(d1));
        System.out.println(apple1 instanceof Apple);

        int r = 2;
        while(r!=0){//java不允许使用非0代表true。
            r--;
            System.out.println(":"+r);
        }
    }
}
