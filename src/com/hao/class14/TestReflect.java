package com.hao.class14;

<<<<<<< HEAD
=======
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
>>>>>>> b0b1d8005bce3f48aa8f3b9b56d54ca4077be94d
import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/29.
 */
<<<<<<< HEAD
class A extends B {
=======
class A extends B{
>>>>>>> b0b1d8005bce3f48aa8f3b9b56d54ca4077be94d
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
<<<<<<< HEAD
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
=======
        int loopTime = 50000;
        Integer i = 0;
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++){
            String str = String.valueOf(i);
        }
        System.out.println("String.valueOf()：" + (System.currentTimeMillis() - startTime) + "ms");
//        new A();
        try {
            //通过泛型新建对象。Class.forName()和A.class.h
            Class<Son> a = Son.class;
//            Class dd = a.getClass();
//            Class = Class.forName("com.hao.class14.Son");
            Class<?> a1 = Integer.TYPE;


            System.out.println("do="+a.getName());
            //创建新的对象。
            Father b=  a.newInstance();
            if(b instanceof Son){//向下转型
                Son son = (Son)b;
            }
            b.do1();
            //创建父类对象
            Class<? super Son> c2 = a.getSuperclass();
            ((Father)c2.newInstance()).do1();
            //class文件反射查询类的方法，使用invoke调用
            Method[] ee = a.getDeclaredMethods();
            Method[] ee1 = a.getMethods();
            String [] names ={"tom","tim","allen","alice"};
            try {
                Method m3 = ee[3];
                m3.invoke(a.newInstance(),null);
                Method m1 = a.getMethod("do5",String.class);
                Method m11 = a.getMethod("do5",int.class);
                for(String name:names)
                    m11.invoke(a.newInstance(),name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Field[] ee2 = a.getFields();
            Constructor[] ee3 = a.getConstructors();


            System.out.println("do=");

            Class c = Class.forName("com.hao.class14.A");
            try {
                Object obj = c.getSuperclass().newInstance();//需要默认的构造方法。
>>>>>>> b0b1d8005bce3f48aa8f3b9b56d54ca4077be94d
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
