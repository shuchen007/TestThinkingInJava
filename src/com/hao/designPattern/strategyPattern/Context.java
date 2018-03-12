package com.hao.designPattern.strategyPattern;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
//策略类
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}
