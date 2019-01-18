package com.psca.concurrent.design.volatiledemo;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/16 13:32
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/16 13:32
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class VolatileDemo {
    private static volatile int INIT_VALUE = 0;

    private final static int MAX_LIMIT = 500;
    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("The value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "UPDATER").start();
    }
}
