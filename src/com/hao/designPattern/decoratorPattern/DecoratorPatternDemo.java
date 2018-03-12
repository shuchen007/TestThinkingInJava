package com.hao.designPattern.decoratorPattern;

/**
 * Created by sunhao on 2018/1/17.
 *
 * @描述
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape shape1 = new Rectangle();
        Shape shape2 = new RedShapeDecorator(new Rectangle());
        Shape shape3 = new RedShapeDecorator((new Circle()));
        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
