package com.psca.concurrent.design.guardedsuspensiondesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 21:06
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 21:06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Request {
    private final String sendMessage;

    public Request(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String getSendMessage() {
        return sendMessage;
    }
}
