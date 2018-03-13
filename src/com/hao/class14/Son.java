package com.hao.class14;

/**
 * Created by Administrator on 2018/3/8.
 */
public class Son extends Father{
//    private static Son son = new Son();
public String ss;
    static{
        System.out.println("初始化son");
    }
    Son() {
    }
     public Son(String x) {
    }

    public static void main(String[] args) {
        System.out.println("1");
    }
    public String do2(){
        System.out.println("do son2!");
        return  "doxx";
    }
    public String do3(){
        System.out.println("do son3!");
        return  "doxx";
    }

    public void do4(){
        System.out.println("do son!");
    }

    public void do5(String x){
        System.out.println("do so=!"+x);
    }
    public void do5(int x){
        System.out.println("do so=!"+x);
    }


}
