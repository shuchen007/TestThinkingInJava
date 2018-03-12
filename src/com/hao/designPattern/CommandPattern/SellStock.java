package com.hao.designPattern.CommandPattern;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
