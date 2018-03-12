package com.hao.designPattern.CommandPattern;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
