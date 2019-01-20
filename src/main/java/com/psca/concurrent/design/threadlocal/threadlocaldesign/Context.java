package com.psca.concurrent.design.threadlocal.threadlocaldesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 23:10
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 23:10
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Context {
    private String name;
    private String cardId;

    public void setName(String name) {
        this.name = name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public String getCardId() {
        return cardId;
    }
}
