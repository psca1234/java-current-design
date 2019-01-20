package com.psca.concurrent.design.guardedsuspensiondesign;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 21:22
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 21:22
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ServerThread extends Thread{
    private volatile boolean closed = false;
    private final RequestQueue requestQueue;
    private final Random random;

    public ServerThread(RequestQueue requestQueue){
        this.requestQueue = requestQueue;
        this.random =new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while(!closed){
            Request request = requestQueue.getRequest();
            if(null == request){
                System.out.println("Received the empty request.");
                continue;
            }
            System.out.println("Server ->" + request.getSendMessage());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Server -> interruted by itself");
                return;
            }
        }
    }

    public void close(){
        this.closed = true;
        this.interrupt();
    }
}
