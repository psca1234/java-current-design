package com.psca.concurrent.design.threadlocal.threadlocaldesign;

import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 23:27
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 23:27
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ExecuteTaskClient {
    public static void main(String[] args) {
        IntStream.range(1,10).forEach(i->new Thread(new ExecuteTask()).start());
    }
}
