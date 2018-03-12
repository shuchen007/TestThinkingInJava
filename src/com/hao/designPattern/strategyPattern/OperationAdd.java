package com.hao.designPattern.strategyPattern;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}
