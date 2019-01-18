package com.psca.concurrent.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/16 21:04
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/16 21:04
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if(state == this.state){
            return;
        }
        this.state = state;
        this.notifyAllObserver();
    }

    public void attech(Observer observer){
        this.observers.add(observer);
    }

    private void notifyAllObserver(){
        observers.stream().forEach(Observer :: update);
    }
}
