package com.hao.designPattern.ObserverPattern;

/**
 * Created by sunhao on 2018/1/17.
 *
 * @描述
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
