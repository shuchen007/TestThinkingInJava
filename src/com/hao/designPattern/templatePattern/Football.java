package com.hao.designPattern.templatePattern;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football  inital");
    }

    @Override
    void startPlay() {
        System.out.println("Football  start");
    }

    @Override
    void endPlay() {
        System.out.println("Football  end");
    }
}
