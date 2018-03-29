package com.hao.collection11;

import java.util.*;

/**
 * Created by Chen Yonggui on 2017/9/7.
 */
public class TestMap {
        public static void main(String[] args)
        {
            //LinkedHashMap 有序
            Map maps = new LinkedHashMap();
            maps.put("2", "张三");
            maps.put("1", "李四");
            maps.put("3", "王五");
            maps.put("4", "赵六");
            System.out.println("LinkedHashMap(有序):"+maps);
            Iterator it = maps.entrySet().iterator();
            System.out.println("LinkedHashMap(有序):"+maps.entrySet());
            while(it.hasNext())
            {
                Map.Entry entity = (Map.Entry) it.next();
                System.out.println("[ key = " + entity.getKey() +
                        ", value = " + entity.getValue() + " ]");
            }
            //TreeMap 自动有序
            Map map2 = new TreeMap();
            map2.put("fd", "张三");
            map2.put("3", "李四");
            map2.put("ac", "王五");
            map2.put("4", "赵六");
            it = null;
            System.out.println("TreeMap(自动有序序):"+map2);
            it = map2.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry entity = (Map.Entry) it.next();
                System.out.println("[ key = " + entity.getKey() +
                        ", value = " + entity.getValue() + " ]");
            }

            //HashMap 无序
            Map map = new HashMap();
            map.put("fd", "张三");
            map.put("4", "李四");
            map.put("ac", "王五");
            map.put("1", "赵六");
            it = null;
            System.out.println("HashMap(无序):"+map);
            it = map.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry entity = (Map.Entry) it.next();
                System.out.println("[ key = " + entity.getKey() +
                        ", value = " + entity.getValue() + " ]");
            }
        }
}
