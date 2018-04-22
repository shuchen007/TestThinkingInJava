package com.hao.designPattern.singletonPattern;

import java.lang.reflect.Constructor;

/**
 * Created by sunhao on 2018/1/12.
 *
 * @描述
 */
//懒汉式在需要的时候才创建，推荐使用饿汉式
public class SingleObject {
    //创建 SingleObject 的一个对象
    /*1、单例类只能有一个实例。
      2、单例类必须自己创建自己的唯一实例。
      3、单例类必须给所有其他对象提供这一实例。*/
    private static  SingleObject INSTANCE = new SingleObject();

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject(){}

    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return INSTANCE;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }

}
