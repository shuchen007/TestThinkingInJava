package com.hao.designPattern.decoratorPattern;

import com.hao.designPattern.decoratorPattern.Shape;

/**
 * Created by sunhao on 2018/1/17.
 *
 * @描述
 */
public abstract class ShapeDecorator implements Shape {
     Shape decoratedShape;
    public ShapeDecorator(Shape decoratorShape){
        this.decoratedShape = decoratorShape;
    }
    public void draw(){
        decoratedShape.draw();
//        setRedBorder(decoratedShape);
    }
//    private void setRedBorder(Shape decoratedShape){
//        System.out.println("Border Color: Red");
//    }

}
