package com.psca.concurrent.design.threadlocal.threadlocaldesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 23:24
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 23:24
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ExecuteTask implements Runnable {
    private QueryFromDBAction queryAction = new QueryFromDBAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();
    @Override
    public void run() {
        queryAction.execute();
        System.out.println("The name query successful");
        httpAction.execute();
        System.out.println("The card id query successful");
        Context context = ActionContext.getInstance().getContext();
        System.out.println("The name is\t"+context.getName()+"\tand CardId is \t"+context.getCardId());
    }
}
