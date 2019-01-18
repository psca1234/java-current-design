package com.psca.concurrent.design.readwriterlock;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/18 21:34
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/18 21:34
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReadWritLockClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new WriteWorker(sharedData, "qwertyuiopasdfg").start();
        new WriteWorker(sharedData, "QWERTYUIOPASDFG").start();
    }
}
