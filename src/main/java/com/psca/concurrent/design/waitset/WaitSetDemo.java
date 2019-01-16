package com.psca.concurrent.design.waitset;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/15 14:39
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/15 14:39
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WaitSetDemo {
    private static final Object LOCK = new Object();
    public static void main(String[] args) throws InterruptedException {
        IntStream.rangeClosed(1,10).forEach(i->new Thread(String.valueOf(i)){
            @Override
            public void run() {
                synchronized (LOCK){
                    try {
                        Optional.of(Thread.currentThread().getName() + " will come to wait set.").ifPresent(System.out::println);
                        LOCK.wait();
                        Optional.of(Thread.currentThread().getName() + " will leave to wait set.").ifPresent(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start());

        Thread.sleep(1_000L);

        IntStream.rangeClosed(1,10).forEach(i->{
            synchronized (LOCK){
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
