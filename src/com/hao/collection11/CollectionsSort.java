package com.hao.collection11;

import java.util.*;

/**
 * Created by Administrator on 2017/9/16.
 */
public class CollectionsSort {
    public static void main(String[] args) {
        LinkedList<String> listout = new LinkedList();
        listout.add(0,"dong");
        listout.add(1,"pig");
        listout.add(2,"app");
//        Collections.sort(listout);//升序
        //升序
        Collections.sort(listout, new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            String map1 = (String) o1;
            String map2 = (String) o2;
            return map1.compareTo(map2);
//            return map1.get("baseTime").toString().compareTo(map2.get("baseTime").toString());
        }
        });
        for(String x :listout){
            System.out.println("x="+x);
        }
//        Collections.sort(listout,Collections.reverseOrder());//降序
        Collections.reverse(listout);//降序
        //降序
//        Collections.sort(listout,Collections.reverseOrder(new Comparator() {
//                    @Override
//                    public int compare(Object o1, Object o2) {
//                        String map1 = (String) o1;
//                        String map2 = (String) o2;
//                        return map1.compareTo(map2);
//                    }
//                }));
        //打印测试
        Iterator it = listout.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
