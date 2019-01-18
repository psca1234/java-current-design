package com.psca.concurrent.design.observerthread;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/16 22:01
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/16 22:01
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public abstract class ObServerableRunnable implements Runnable {
    private LifecycleListener lifecycleListener;

    public ObServerableRunnable(LifecycleListener lifecycleListener) {
        this.lifecycleListener = lifecycleListener;
    }

    protected void notifyChange(final RunnableEvent event){
        lifecycleListener.onEvent(event);
    }

    public enum RunnableState{
        RUNNING,ERROR,DONE
    }

    public static final class RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
