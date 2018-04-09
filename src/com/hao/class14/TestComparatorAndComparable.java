package com.hao.class14;

import java.util.*;

/**
 * Created by Administrator on 2018/3/29.
 */
public class TestComparatorAndComparable extends Son{
    public static void main(String[] args) {
        List<String> listout = new ArrayList<String>();
        listout.add(0, "dong");
        listout.add(1, "pig");
        listout.add(2, "app");
        Collections.sort(listout);//升序
//        Collections.sort(listout,Collections.reverseOrder());//降序1
//        Collections.reverse(listout);//降序2
        //降序3，匿名内部类
        Collections.sort(listout,Collections.reverseOrder(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        String map1 = (String) o1;
                        String map2 = (String) o2;
                        return map1.compareTo(map2);
                    }
                }));
//        Collections.sort(listout,new MyComparator());
        for (String x : listout) {
            System.out.println("x=" + x);
        }
    }

    //静态内部类
    static class MyComparator implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            String map1 = (String) o1;
            String map2 = (String) o2;
            return map1.compareTo(map2);
//            return map1.get("baseTime").toString().compareTo(map2.get("baseTime").toString());
        }
    };
}
