package com.hao.collection11;

import java.util.*;

public class Main {
   static int a = 1 ;
    static Orange orange = new Orange();
//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        LinkedList apples = new LinkedList();
        ArrayList arrayList = new ArrayList();
        apples.add(new Apple());
       apples.add("do");
        apples.addFirst("wo");
//        for(int i=0;i<apples.size();i++)
           Apple apple = (Apple) apples.get(1);
        System.out.println(apples.contains(apple));
        System.out.println(apples.containsAll(apples));
        System.out.println(apples.indexOf(apple));
        apples.add("ddd");
        Iterator it = apples.iterator();

        System.out.println("d="+apples.size());
        while(it.hasNext()){
            System.out.println("it="+(it.next()));
        }
//        for(Iterator it1 = apples.iterator();it1.hasNext();){
//            System.out.println(((Apple)it1.next()).id());
//        }


        List<Integer> c = new ArrayList<Integer>() ;

        c.add(2);
        c.add(1);
//        apples.add(new Orange());
        System.out.println(c.get(1));
        for(int i=0;i<c.size();i++)
            System.out.println(c);

        Map map = new HashMap();
        map.put("s", "dog");
        map.put("2","");
        map.size();
        System.out.println("map="+map.get("2"));
        int do1 = 1;
        try{
            do1 = Integer.parseInt(map.get("2").toString());
        }catch (Exception e){
            do1 = 1;
        }
        System.out.println(do1);
        Collection values = map.values();
        System.out.println("values="+values);
        Set set = map.entrySet();
        System.out.println("entry="+set);
        Iterator its = c.listIterator(1);//开始便利的起点index。
        for(int i=0;its.hasNext();){
            System.out.println("its="+its.next());
        }
        for(Object o : map.values()){
            System.out.println(map.get("2"));
        }
        System.out.println(map.size());
        int b = new Main().a;
        new Main().b();
        new Main().c();

//        a=5;
//        System.out.println("a0="+a);
        new Main().b();
        System.out.println("orange="+orange);
    }

     public void a(){
         int b = a;
//        a=2;
         System.out.println("orange1="+orange);
         System.out.println("a1="+a);
    }
    //静态变量初始化只有一个值，随着静态方法的改变尔改变； static int a =1
    // 非静态变量只是一个引用，只能在方法内改变值的应用，未改变非静态变量值；int a= 1
    // final变量在任何方法内都不能改变其值。final int a=1;
    // 静态方法只能使用由static定义的变量,非静态方法可个以使用所有变量
    // final定义的变量或者方法只能new对象来调用，加上static直接类名调用。static final int a= 1;
    //
    public static void b(){
        System.out.println("a3="+Main.a);
    }
    public void c(){
        int x = Main.a;
        System.out.println("a3=a3="+x);
    }
    public String d(){
        System.out.println("a3=a4");
        return  "dog";
    }
}

class Apple1{

    static int i;//static可通过类名直接访问，初始化值后面可更改。
    private  final int id =i++;//final定义常量，不可更改。
    public String id() {
        return "id=" + id;
    }
    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }
}
class Orange{
    public void test(){
        int b = new Main().a;
    }

    @Override
    public String toString() {
        return "Orange{}";
    }
}

