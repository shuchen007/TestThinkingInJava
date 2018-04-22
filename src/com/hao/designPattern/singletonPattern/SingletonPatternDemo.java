package com.hao.designPattern.singletonPattern;

/**
 * Created by sunhao on 2018/1/12.
 *
 * @描述
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();
        SingleObjectEnum object1 = SingleObjectEnum.INSTANCE;
        //显示消息
        object.showMessage();
        object1.showMessage();
    }
}
