package com.hao.class14;

/**
 * Created by sunhao on 2018/3/12.
 *
 * @描述
 */
public class SinglePattern {
    private static SinglePattern SINGLE_PATTERN = new SinglePattern();
    public static SinglePattern getSinglePattern(){
        return SINGLE_PATTERN;
    }
    static {
        System.out.println("静态块");
    }
    private SinglePattern() {
        System.out.println("构造");
    }


    public String getAnimal(int x){
        System.out.println("getAnimal");
        return String.valueOf(x)+"ai";
    }

    public static final void getAnim(){
        System.out.println("静态方法");
    }
}