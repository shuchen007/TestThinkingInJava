package com.hao.String13;

import java.util.Random;

/**
 * Created by Administrator on 2017/7/5.
 */
public class TestString {
    public static void main(String[] args){
        Random rand = new Random();
        String s= "fd23432df";
        System.out.println(s.toUpperCase());
        System.out.println(s.substring(3));
        System.out.println(s.replace("d","k"));
        System.out.println(s.replaceAll("-f","rr"));//regex正则表达式

        int x=2;
        StringBuilder result = new StringBuilder("[");
        for(int i=0;i<12;i++){
            result.append(rand.nextFloat()*(8-2)+2);
            result.append(", ");
        }
        result.delete(result.length()-2,result.length());
        result.append("]");
        System.out.println(result);
        System.out.printf("%d\n",x);

        String d = "-143sdf";
        System.out.println(d);
        System.out.println(d.matches("-?\\d+"));
        System.out.println(d.matches("[14]"));
        System.out.println(d.matches("4?"));
    }
}
