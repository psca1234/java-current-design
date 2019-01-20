package com.psca.concurrent.design.threadlocal.threadlocaldesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 23:18
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 23:18
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class QueryFromDBAction {
    public void execute(){
        try {
            Thread.sleep(1000L);
            String name = "SHICHAO\tPAN"+Thread.currentThread().getName();
            ActionContext.getInstance().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
