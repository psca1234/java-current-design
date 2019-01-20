package com.psca.concurrent.design.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 18:13
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 18:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AsynFutureClient {
    public static void main(String[] args) throws InterruptedException{
        FutureService<String> futureService = new FutureService<>();
        futureService.submit(() -> {
            try {
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out :: println);

        System.out.println("==================");
        System.out.println("do other things...");
        Thread.sleep(1000L);
        System.out.println("==================");
    }
}
