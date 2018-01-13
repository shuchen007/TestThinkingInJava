package com.hao.designPattern.abstractFactoryPattern;

/**
 * Created by sunhao on 2018/1/12.
 *
 * @描述
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
    //使用反射机制可以解决每次增加一个产品时，都需要增加一个对象实现工厂的缺点
    public static AbstractFactory getClass(Class clazz) {
//    public static Shape getClass(Class<?extends Shape> clazz) {
//        Object obj = null;
        AbstractFactory obj = null;
        try {
            obj = (AbstractFactory)Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
