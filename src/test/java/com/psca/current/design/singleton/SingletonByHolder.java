package com.psca.current.design.singleton;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/14 21:38
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/14 21:38
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SingletonByHolder {
    @Test
    public void testSingletonByHolder(){
        IntStream.rangeClosed(1, 100)
                .forEach(i -> new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        System.out.println(SingletonByHoder.getInstance());
                    }
                }.start());
    }
}
