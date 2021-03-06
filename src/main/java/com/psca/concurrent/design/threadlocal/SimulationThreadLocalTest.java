package com.psca.concurrent.design.threadlocal;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 23:08
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 23:08
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SimulationThreadLocalTest {
    private static final SimulationThreadLocal<String>  threadLocal = new SimulationThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            threadLocal.set("SHICHAO\tPAN");
            System.out.println(Thread.currentThread().getName()+"\t"+threadLocal.get());
        },"t1").start();

        new Thread(()->{
            threadLocal.set("FANG\tYAN");
            System.out.println(Thread.currentThread().getName()+"\t"+threadLocal.get());
        },"t2").start();

        threadLocal.set("AI");
        System.out.println(Thread.currentThread().getName()+"\t"+threadLocal.get());
    }
}
