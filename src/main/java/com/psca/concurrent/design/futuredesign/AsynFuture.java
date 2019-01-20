package com.psca.concurrent.design.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 18:08
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 18:08
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFuture<T> implements Future<T> {
    private volatile boolean done = false;

    private T result;

    public void doneNotify(T result){
        synchronized (this){
            this.result = result;
            this.notifyAll();
            this.done = true;
        }
    }
    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while(!done){
                this.wait();
            }
        }
        return result;
    }
}
