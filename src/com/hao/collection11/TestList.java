package com.hao.collection11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("b","c","a","e"));
//        list.add("b");
//        list.add("c");
//        list.add("c");
//        list.add("e");
        System.out.println("do="+list);
//        for (String x : list) {
//            if("c".equals(x)){
//                list.remove(x);
//            }
//            System.out.println(list);
//        }

        for (int i = 0; i < list.size(); i++) {
            String y = list.get(i);
            if("b".equals(list.get(i))){
                list.remove(i);
            }
            System.out.println(list);
        }

//        for(Iterator it = list.iterator();it.hasNext();){
//            String z = it.next().toString();
//            if("c".equals(z)){
//                it.remove();
//            }
//            System.out.println(list);
//        }
        List list1 = new ArrayList();
        list1.addAll(list);
        System.out.println(list);
        System.out.println(list1);
    }

}
