package com.hao.collection11;

import java.util.*;

/**
 * Created by Administrator on 2018/3/8.
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("2", "xue");
        linkedHashMap.put("3", "xi");
        linkedHashMap.put("1", "wo");
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(((Map.Entry)it.next()).getKey());
        }

        //TreeMap
        Map treeMap = new TreeMap();
        treeMap.put("2", "xue");
        treeMap.put("3", "xi");
        treeMap.put("1", "wo");
        Iterator iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(((Map.Entry)iterator.next()).getKey());
        }


    }
}
