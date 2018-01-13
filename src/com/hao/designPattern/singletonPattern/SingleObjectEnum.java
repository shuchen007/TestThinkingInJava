package com.hao.designPattern.singletonPattern;

/**
 * Created by sunhao on 2018/1/12.
 *
 * @描述
 */
//枚举式，新方法
public enum  SingleObjectEnum {
    INSTANCE;
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
