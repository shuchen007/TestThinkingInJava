package com.hao.designPattern.strategyPattern;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        int x = context.executeStrategy(2,3);
        System.out.println(x);

        Context context1 = new Context(new OperationSubstract());
        int x1 = context1.executeStrategy(2,3);
        System.out.println(x1);

        Context context2 = new Context(new OperationMultiply());
        int x2 = context2.executeStrategy(2,3);
        System.out.println(x2);
    }
}
