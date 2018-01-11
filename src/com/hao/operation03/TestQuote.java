package com.hao.operation03;

/**
 * Created by Administrator on 2017/8/25.
 */
public class TestQuote {
    public static void main(String[] args) {
        //基本数据类型复制的是内容，而a中的内容不受影响。
        int a = 1;
        int b= a;
        System.out.println(a);
        b = 3;
        System.out.println(a+"\""+b);
        a = 4 ;
        b = a;
        System.out.println(a+"\""+b);

        //对象类型复制的是引用，将引用从一个地方复制到另一个地方。
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        apple1.i = 1 ;
        apple2.i = 2 ;
        System.out.println("f="+apple1.i+apple2.i);
//        apple1 = apple2 ;
        apple1.i = apple2.i ;//不直接操作对象，使对象独立。
        System.out.println("f="+apple1.i+apple2.i);
        apple2.i = 4 ;//1和2都一样
        System.out.println("f="+apple1.i+apple2.i);

        //避免直接对对象内的域进行操作。
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        orange1.setJ(4);
        orange2.setJ(5);
        System.out.println("d="+orange1.getJ()+orange2.getJ());
//        orange1 = orange2 ;
        orange1.setJ(orange2.getJ());
        System.out.println("d="+orange1.getJ()+orange2.getJ());
        orange2.setJ(6);//1和2都一样
        System.out.println("d="+orange1.getJ()+orange2.getJ());
    }
}
class  Orange{
    private int j ;
    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
