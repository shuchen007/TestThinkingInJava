package com.hao.designPattern.templatePattern;

/**
 * Created by sunhao on 2018/1/16.
 *
 * @描述
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        game.ddo();
        System.out.println();
        game = new Football();
        game.play();
    }
}
