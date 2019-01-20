package com.psca.concurrent.design.balkingdesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 0:12
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 0:12
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BalkingClient {
    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("classpath:balking.txt", Thread.currentThread().getName()+"\t===BEGIN====\n");
        new CustomerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }
}
