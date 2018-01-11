package com.hao.arrry16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Dm dm = new Dm();
        dm.i = 2;

        //数组及二维数组的定义和访问。
        Random random = new Random(23);
        Random random1 = new Random(23);
        int[] dm3 = new int[]{1,2,2,3};
        int a = dm3.length;
        dm3[0]=random.nextInt(23);
        dm3[1]=random.nextInt(23);
        System.out.println(dm3[0]+"+"+dm3[1]+"+"+dm3[2]);

        Dm[] dms1[] = new Dm[10][3];
        dms1[0][1] = new Dm();
        Dm dmx[] = {new Dm(),new Dm(),new Dm()};

        String x[] = {"ds","df","fds"};
        String s[]=x;//只是复制的数组的一个引用，值照样改变。
        s[1] = s[1]+23;
        System.out.println(x[1]);
        String[] x1[] = {{"ds","df"},{"fds1","df1"}};
        System.out.println(x1[1][0]);
        int[] d[] = new int[2][4];
        d[0][2] = 23;

        Dm dms[] = new Dm[8];
        for(int i = 0; i<8 ; i++){
            dms[i] = new Dm("dfww");
        }
        System.out.println(dms);
        System.out.println(dms[1].equals(new Dm()));
        System.out.println("Hello World!");

        System.out.println(Arrays.toString(x));
        List intList = new ArrayList(Arrays.asList(1,2,3));
        intList.addAll(1,intList);
        System.out.println(intList);
        System.out.println(intList.get(2));

        Dm.f(2,"df", "df");
        Dm.f(3,"df", "df", "23f");
    }

}
class Dm{
    static void f(Object args,String... sts){//可变参数数组列表
        for(String x: sts){
            System.out.println(x);
        }
    }
    public Dm() {
    }
    public Dm(String x) {
        System.out.print(x);
    }
    static int i;//static可通过类名直接访问，初始化值后面可更改。
    private  final int id =i++;//final定义常量，不可更改。
    /*@Override
    public String toString() {
        return "id=" + id;
    }*/
    @Override
    public String toString() {
        return "Dm{}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dm dm = (Dm) o;
        return true;
    }
    @Override
    public int hashCode() {
        return 23;
    }
}