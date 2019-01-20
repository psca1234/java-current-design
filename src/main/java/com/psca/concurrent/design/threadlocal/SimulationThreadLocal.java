package com.psca.concurrent.design.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 22:58
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 22:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SimulationThreadLocal<T> {
    private final Map<Thread,T> map = new HashMap<>();

    public T get(){
        synchronized (this){
            T result = map.get(Thread.currentThread());
            if(result == null){
                return initalValue();
            }else{
                return result;
            }
        }
    }

    public T initalValue() {
        return null;
    }

    public void set(T value){
        synchronized (this){
            map.put(Thread.currentThread(),value);
        }
    }
}
