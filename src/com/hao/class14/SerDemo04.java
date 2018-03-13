package com.hao.class14;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SerDemo04{
    public static void main(String args[]) throws Exception{
        List<String> list = new ArrayList<String>();
        list.add("a");
        System.out.println(list);
//        Class<SinglePattern> aClass = (Class<SinglePattern>) Class.forName("com.hao.class14.SinglePattern");
        Class<SinglePattern> aClass = SinglePattern.class;
//        SinglePattern singlePattern = aClass.newInstance();//优先调用无参构造方法，再初始化。
//        SinglePattern singlePattern1 = aClass.getMethod("");//优先调用无参构造方法，再初始化。
        //单例模式
        SinglePattern singlePattern = SinglePattern.getSinglePattern();

        System.out.println(singlePattern.getAnimal(3));
        //通过反射获取具体方法并调用。
        Method method = aClass.getMethod("getAnimal",int.class);
        Object obj = method.invoke(singlePattern,4);
        System.out.println(obj);

        //通过反射破坏单例
        Constructor constructor = aClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        SinglePattern singlePattern1 = (SinglePattern) constructor.newInstance();
        System.out.println(singlePattern1.getAnimal(3));


//        new Person();
//        ser() ;
//        dser() ;
    }
    public static void ser() throws Exception {
        File f = new File("D:" + File.separator + "test.txt") ;
        ObjectOutputStream oos = null ;
        OutputStream out = new FileOutputStream(f) ;
        oos = new ObjectOutputStream(out);
        Person p = new Person(23,"fu");
        oos.writeObject(p) ;
        oos.close() ;  // 关闭
    }
    public static void dser() throws Exception {
        File f = new File("D:" + File.separator + "test.txt") ;
        ObjectInputStream ois = null ;
        InputStream input = new FileInputStream(f) ;
        ois = new ObjectInputStream(input);
        Object obj = ois.readObject() ;
        ois.close() ;  // 关闭
        System.out.println(obj) ;
    }
}