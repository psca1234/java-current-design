package com.psca.concurrent.design.observerthread;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/16 22:04
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/16 22:04
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface LifecycleListener {
    void onEvent(ObServerableRunnable.RunnableEvent runnableEvent);
}
