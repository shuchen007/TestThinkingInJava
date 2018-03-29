package com.hao.collection11;

public class Apple{
    String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    static int i;//static可通过类名直接访问，初始化值后面可更改。
    private  final int id =i++;//final定义常量，不可更改。
    public String id() {
        return "id=" + id;
    }
    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +"\n"+
                "a=" + a +
                '}';
    }
}
