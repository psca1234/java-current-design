package com.psca.current.design.singleton;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/14 21:40
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/14 21:40
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SingletonByEnum {
    private enum SingletonEnum{
        INSTANCE;
        private final SingletonByEnum singletonByEnum;
        SingletonEnum(){
            singletonByEnum = new SingletonByEnum();
        }

        public SingletonByEnum getInstance(){
            return singletonByEnum;
        }
    }

    public static SingletonByEnum getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }
}
