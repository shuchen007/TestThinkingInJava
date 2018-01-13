package com.hao.designPattern.abstractFactoryPattern;


/**
 * Created by Administrator on 2018/1/10.
 */
public class ColorFactory extends AbstractFactory{
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("red")){
            return new Red();
        } else if(color.equalsIgnoreCase("green")){
            return new Green();
        } else if(color.equalsIgnoreCase("blue")){
            return new Blue();
        }
        return null;
    }

    //使用 getShape 方法获取形状类型的对象
    @Override
    public Shape getShape(String color){
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
