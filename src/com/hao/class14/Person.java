package com.hao.class14;

import java.io.Serializable;

public class Person implements Serializable{
    private String name ;
    // 声明name属性，但是此属性不被序列化
    private transient int age ;

    public Person() {
        System.out.println("do");
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString(){
// 覆写toString()方法
        return "姓名：" + this.name + "；年龄：" + this.age ;
    }
}

