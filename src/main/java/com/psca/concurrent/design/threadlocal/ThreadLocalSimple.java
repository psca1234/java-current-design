package com.psca.concurrent.design.threadlocal;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 22:41
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 22:41
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadLocalSimple {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "SHICHAO\tPAN";
        }
    };
    public static void main(String[] args) {
        String result = threadLocal.get();
        System.out.println(Thread.currentThread()+"\t"+result);

        new Thread(()->{
            threadLocal.set("FANG\tYAN");
            System.out.println(Thread.currentThread().getName()+"\t"+threadLocal.get());
        },"t1").start();
    }
}
