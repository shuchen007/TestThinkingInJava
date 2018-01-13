package com.hao.designPattern.abstractFactoryPattern;


/**
 * Created by Administrator on 2018/1/10.
 */
public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    //使用 getShape 方法获取形状类型的对象
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    //使用反射机制可以解决每次增加一个产品时，都需要增加一个对象实现工厂的缺点
    @Override
    public Shape getClass(Class clazz) {
//    public static Shape getClass(Class<?extends Shape> clazz) {
//        Object obj = null;
        Shape obj = null;

        try {
            obj = (Shape)Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
