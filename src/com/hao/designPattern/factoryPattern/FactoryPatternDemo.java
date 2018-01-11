package com.hao.designPattern.factoryPattern;

/**
 * Created by Administrator on 2018/1/10.
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        shape2.draw();
        ShapePlus shape21 =shapeFactory.getShape1("RECTANGLE");
        shape21.sub();
        ShapePlus shape22 = new Rectangle();
        shape22.sub();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //调用 Square 的 draw 方法
        shape3.draw();
        System.out.println("**************************************");
        //使用反射机制，创建对象。
        Shape rect =  ShapeFactory.getClass(Rectangle.class);
        rect.draw();
        Square square = (Square) ShapeFactory.getClass(Square.class);
        square.draw();
    }
}
