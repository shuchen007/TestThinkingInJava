package com.hao.String13;

import com.hao.collection11.Apple;

import java.util.*;

public class TestNull {
    public static void main(String[] args) {
        //测试int的equals和==,基本数据类型在声明的同时就分配了数据空间。引用类型声明时未分配。
        int x= 3;
        int x1;
        x1= x;
        x=x+3;
        System.out.println(x1);
        if(x==6 ) System.out.println("x_true");//false

        String w = "33.9";
        String w1 = "33.3";
        Float w2 = 3.9f;
        Double w3 = x+0.3;
        String xs = Float.parseFloat(w1)+3+" ";
        int xd = (int)(w3+3.2);
        System.out.println(w3);
        System.out.println(xd);
        System.out.println(Double.parseDouble(w1)+3);

        Apple today;              //将变量分配一个保存引用的空间
        today = new Apple();     //这句话是2步，首先执行new MyDate（），给today变量开辟数据空间，然后再执行赋值操作
        System.out.println(today);
        //测试String的equals和==
        String y = "d";
        String ya ="as";
        String yb ="as";
        String yc = new String("as");
        String yd = new String("as");
        System.out.println(ya==yb);
        System.out.println("as".equals(ya));
        System.out.println(yc==yd);
        System.out.println(ya==yc);
        y=y+"x";
        if(y.equals("dx")) System.out.println(y);//dx
        System.out.println("boolean="+("dx"==(y)));//false

        //测试StringBuilder的equals和==
        StringBuilder y1 = new StringBuilder("a");//StringBuilder需要toString后。
        y1.append("x");
        if("ax".equals(y1.toString())) System.out.println(y1);//dx
        if(y1.toString()!="a") System.out.println("false1");//false

        //测试list的null和" ",new ArrayList后为空。
        List<Apple> list = new LinkedList<Apple>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        a1.setA("3");
        a2.setA("2");
        list.add(a1);
        list.add(a2);
        Collections.sort(list, new Comparator<Apple>() {//匿名内部类
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getA().compareTo(o2.getA());
            }
        });
//		if(null = dog) System.out.println("kk");
        for (int i = 0; null != list &&i < list.size(); i++) {
            System.out.println(list.get(i).getA());
        }
        System.out.println("list="+list);
    }
}

