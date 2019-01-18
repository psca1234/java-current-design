package com.psca.concurrent.design.observer;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/16 21:03
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/16 21:03
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attech(this);
    }

    public abstract void update();
}
