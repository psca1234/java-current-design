package com.psca.concurrent.design.observer;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/16 21:18
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/16 21:18
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class OctalObserver extends Observer{
    public OctalObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal ObServer\t"+Integer.toOctalString(subject.getState()));
    }
}
