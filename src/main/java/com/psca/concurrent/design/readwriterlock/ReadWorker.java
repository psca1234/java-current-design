package com.psca.concurrent.design.readwriterlock;


/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/18 21:26
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/18 21:26
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReadWorker extends Thread {
    private final SharedData sharedData;

    public ReadWorker(SharedData data){
        this.sharedData = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = sharedData.readFromShardData();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
