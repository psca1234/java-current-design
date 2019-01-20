package com.psca.concurrent.design.futuredesign;

import java.util.function.Consumer;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 18:07
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 18:07
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class FutureService<T> {
    public <T> Future<T> submit(final FutureTask<T> futureTask, Consumer<T> consumer){
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(()->{
            T result= futureTask.call();
            asynFuture.doneNotify(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }
}
