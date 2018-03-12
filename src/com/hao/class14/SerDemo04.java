package com.hao.class14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerDemo04{
    public static void main(String args[]) throws Exception{
        List<String> list = new ArrayList<String>();
        list.add("a");
        System.out.println(list);
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