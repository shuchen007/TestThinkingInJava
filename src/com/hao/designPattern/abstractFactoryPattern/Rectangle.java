package com.hao.designPattern.abstractFactoryPattern;

import com.hao.designPattern.factoryPattern.ShapePlus;

/**
 * Created by Administrator on 2018/1/10.
 */
public class Rectangle implements ShapePlus,Shape {
    @Override
    public void draw() {
        System.out.println("rec");
    }

    @Override
    public void sub() {
        System.out.println("do sub");
    }
}
