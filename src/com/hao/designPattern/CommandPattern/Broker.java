package com.hao.designPattern.CommandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
