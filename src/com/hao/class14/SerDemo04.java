package com.hao.class14;


import java.io.*;
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
        SinglePattern singlePattern = aClass.newInstance();//优先调用无参构造方法，再初始化。
        System.out.println(singlePattern.getAnimal(3));
        Method method = aClass.getMethod("getAnimal",int.class);
        Object obj = method.invoke(singlePattern,4);
        System.out.println(obj);



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