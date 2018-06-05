package com.hao.arrry16;



import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/6/3.
 */
public class TestStringBuffer {
    public static void process(String str){
        str = "A";
    }
    public static void process(StringBuffer sb){
        sb = new StringBuffer();
        sb.append("A");
    }

    public static void process(String str, StringBuffer sb) {
        str = new String("A");
        sb.append("A");
    }

    public static void main(String[] args) {
        String str = "a";
        StringBuffer sb = new StringBuffer("a");
        process(str);
        System.out.println(str);
        process(sb);
        System.out.println(sb);
        process(str, sb);
        System.out.println(str);
        System.out.println(sb);
        int[] a = {2,3,5,2,65,4,1};
        int ff[] = new int[a.length];
        ff[0] = a[1];
        System.out.println(Arrays.toString(sortList(a)));
        System.out.println(Arrays.toString(selectSort(a)));
        System.out.println(Arrays.toString(sortCheck(a)));
    }

    //冒泡排序
    public static int[] sortCheck(int[] x){
        int num = x.length;
        for (int i = 0; i < num-1; i++) {
            for (int j = 0; j < num -1; j++) {
                int tmp;
                if (x[j]>x[j+1]){
                    tmp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = tmp;
                }
            }
        }
        return x;
    }
    //选择排序
    public static int[] selectSort(int array[]) {
        int t = 0;
        for (int i = 0; i < array.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[index] < array[j])
                    index = j;
                    t = array[i];
                    array[i] = array[index];
                    array[index] = t;
        }
        return array;
    }
    //利用集合排序
    public static  int[] sortList(int[] x){
        List<Integer> list = new ArrayList<Integer>();
        for(int a: x){
            list.add(a);
        }
        Collections.sort(list);
        Object[] x1 = list.toArray();
        int[] a = new int[x1.length];
        for (int i = 0; i < x1.length; i++) {
            a[i] = (int) x1[i];
        }
        return a;
    }
}
