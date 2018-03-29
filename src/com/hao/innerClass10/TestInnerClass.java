package com.hao.innerClass10;

import java.util.*;

class Apple3{
    void a(){
        System.out.println("dog3");
    }
}
public class TestInnerClass {
    private int p1 = 12;
    public static void main(String[] args) {
        LinkedList apples = new LinkedList();
        ArrayList arrayList = new ArrayList();
        TestInnerClass q = new TestInnerClass();
        TestInnerClass.Apple2 d = q.new Apple2();
        TestInnerClass.Apple1 d1 = new TestInnerClass().new Apple1();
        Apple3 d3 = new Apple3();
        d1.a();
        d3.a();

        apples.add(d);
        System.out.println(apples);
    }
    String x(){
        return "do"+p1;
    }
    public class Apple1{
        void a(){
            System.out.println("dog1"+p1);
        }
    }
    //成员内部类
    class Apple2{
        void a(){
            System.out.println("dog2"+new Apple1());
        }
    }
}

