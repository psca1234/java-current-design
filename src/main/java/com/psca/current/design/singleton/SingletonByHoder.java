package com.psca.current.design.singleton;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/14 21:35
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/14 21:35
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SingletonByHoder {
    private SingletonByHoder(){

    }

    private static class SingletonObjHoder{
        private static final SingletonByHoder sigletonByHoder = new SingletonByHoder();
    }

    public static SingletonByHoder getInstance(){
        return SingletonObjHoder.sigletonByHoder;
    }
}
