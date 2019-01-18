package com.psca.concurrent.design.observerthread;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/16 22:12
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/16 22:12
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLifecycleObserver implements LifecycleListener {
    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids) {
        ids.stream().forEach(id -> {
            new Thread(new ObServerableRunnable(this) {
                @Override
                public void run() {
                    try {
                        notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                        System.out.println("query for the id " + id);
                        Thread.sleep(1000L);
                        notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                    }
                }
            }).start();
        });
    }

    @Override
    public void onEvent(ObServerableRunnable.RunnableEvent runnableEvent) {
        synchronized (LOCK) {
            System.out.println("The runnable [" + runnableEvent.getThread().getName() + "] data changed and state is [" + runnableEvent.getState() + "]");
            if (runnableEvent.getCause() != null) {
                System.out.println("The runnable [" + runnableEvent.getThread().getName() + "] process failed.");
                runnableEvent.getCause().printStackTrace();
            }
        }
    }
}
