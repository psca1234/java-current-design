package com.psca.concurrent.design.futuredesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 18:06
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 18:06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface FutureTask<T> {
    T call();
}
