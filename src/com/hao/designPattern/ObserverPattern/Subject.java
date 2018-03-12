package com.hao.designPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhao on 2018/1/17.
 *
 * @描述
 */
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
