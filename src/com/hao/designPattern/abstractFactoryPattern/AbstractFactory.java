package com.hao.designPattern.abstractFactoryPattern;

/**
 * Created by sunhao on 2018/1/12.
 *
 * @描述
 */
public abstract class AbstractFactory {//也可以是接口。
    abstract Color getColor(String color);
    abstract Shape getShape(String shape) ;
    public String getString(String x){
        String y = x.toUpperCase().toString();
        return y;
    }
    abstract Shape getClass(Class clazz);
}
