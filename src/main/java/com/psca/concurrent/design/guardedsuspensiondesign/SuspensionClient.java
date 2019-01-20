package com.psca.concurrent.design.guardedsuspensiondesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 21:33
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 21:33
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SuspensionClient {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"SHICHAO\tPAN").start();
        ServerThread serverThread = new ServerThread(requestQueue);
        serverThread.start();
        try {
            Thread.sleep(20_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            serverThread.close();
        }
    }
}
