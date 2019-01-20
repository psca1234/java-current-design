package com.psca.concurrent.design.balkingdesign;

import java.io.IOException;
import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/21 0:06
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/21 0:06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CustomerThread extends Thread {
    private final BalkingData balkingData;
    private final Random random = new Random(System.currentTimeMillis());

    public CustomerThread(BalkingData balkingData) {
        super("Customer");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        try {
            balkingData.save();
            for(int i=0;i<20;i++){
                balkingData.change(Thread.currentThread().getName()+"->No\t"+(i++));
                Thread.sleep(random.nextInt(1000));
                balkingData.save();
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
