package com.psca.concurrent.design.threadlocal.threadlocaldesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 23:21
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 23:21
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class QueryFromHttpAction {
    public void execute(){
        Context context = ActionContext.getInstance().getContext();
        String name = context.getName();
        String cardId = getCardId(name);
        context.setCardId(cardId);
    }

    private String getCardId(String name) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "435467523543" + Thread.currentThread().getId();
    }
}
