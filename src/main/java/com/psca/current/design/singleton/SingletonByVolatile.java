package com.psca.current.design.singleton;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/14 21:25
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/14 21:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SingletonByVolatile {

    private static volatile SingletonByVolatile singletonByVolatile;

    private SingletonByVolatile(){

    }

    public static SingletonByVolatile getInstance(){
        if (null == singletonByVolatile){
            synchronized (SingletonByVolatile.class){
                if(null == singletonByVolatile){
                    singletonByVolatile = new SingletonByVolatile();
                }
            }
        }
        return SingletonByVolatile.singletonByVolatile;
    }


}
