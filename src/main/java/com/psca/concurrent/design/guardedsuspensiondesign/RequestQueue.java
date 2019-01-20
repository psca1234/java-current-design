package com.psca.concurrent.design.guardedsuspensiondesign;

import java.util.LinkedList;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 21:07
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 21:07
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class RequestQueue {
    private static final LinkedList<Request> requestQueue = new LinkedList<>();

    public Request getRequest(){
        synchronized (requestQueue){
            while(requestQueue.size() <=0){
                try {
                    requestQueue.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
            return requestQueue.removeFirst();
        }
    }

    public void put(Request request){
        synchronized (requestQueue){
            requestQueue.addLast(request);
            requestQueue.notifyAll();
        }
    }
}
