package com.psca.concurrent.design.observer;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/16 21:12
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/16 21:12
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject){
        super(subject);
    }
    @Override
    public void update() {
        System.out.println("Binary ObServer\t"+Integer.toBinaryString(super.subject.getState()));
    }
}
