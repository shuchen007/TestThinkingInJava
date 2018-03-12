package com.hao.designPattern.ObserverPattern;

/**
 * Created by sunhao on 2018/1/17.
 *
 * @描述
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
