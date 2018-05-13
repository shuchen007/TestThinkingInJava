package com.hao.designPattern.templatePattern;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板模式
    public final void play(){
        //初始化游戏
        initialize();
        //开始游戏
        startPlay();
        //结束游戏
        endPlay();
        //定义公共的方法或动作，继承了这个类的都将共享方法。
        System.out.println();
    }
    public final void ddo(){
        System.out.println("dodo");
    }
}
