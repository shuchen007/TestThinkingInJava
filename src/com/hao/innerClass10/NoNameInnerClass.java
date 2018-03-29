package com.hao.innerClass10;
/**
 * Created by Administrator on 2017/9/16.
 */

import java.util.*;

/**
 * Created by Administrator on 2017/9/16.
 */
public class NoNameInnerClass {
    //静态内部类和匿名内部类
    static class MyComparator implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            String map1 = (String) o1;
            String map2 = (String) o2;
            return map1.compareTo(map2);
//            return map1.get("baseTime").toString().compareTo(map2.get("baseTime").toString());
        }
    };
    public static void main(String[] args) {
        List<String> listout = new LinkedList();
        listout.add(0, "dong");
        listout.add(1, "pig");
        listout.add(2, "app");
//        Collections.sort(listout);//升序
        //升序,匿名内部类
        Collections.sort(listout, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String map1 = (String) o1;
                String map2 = (String) o2;
                return map1.compareTo(map2);
//            return map1.get("baseTime").toString().compareTo(map2.get("baseTime").toString());
            }
        });
        Collections.sort(listout,new MyComparator());
        for (String x : listout) {
            System.out.println("x=" + x);
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
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

