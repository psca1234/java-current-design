package com.psca.concurrent.design.guardedsuspensiondesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 21:13
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 21:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ClientThread extends Thread {
    private final RequestQueue requestQueue;
    private final String sendMessage;
    private final Random random;

    public ClientThread(RequestQueue requestQueue,String sendMessage){
        this.requestQueue = requestQueue;
        this.sendMessage  = sendMessage;
        random = new Random(System.currentTimeMillis());
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Client ->"+sendMessage);
            requestQueue.put(new Request(sendMessage));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
