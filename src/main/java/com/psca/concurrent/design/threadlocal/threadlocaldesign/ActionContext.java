package com.psca.concurrent.design.threadlocal.threadlocaldesign;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/20 23:12
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/20 23:12
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ActionContext {
    private final static ThreadLocal<Context> threadLocal = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private enum ActionContextSingleton{
        INSTANCE;
        private ActionContext actionContext;
        ActionContextSingleton(){
            actionContext = new ActionContext();
        }
        public ActionContext getInstance(){
            return this.actionContext;
        }
    }

    public static ActionContext getInstance(){
        return ActionContextSingleton.INSTANCE.getInstance();
    }


    public Context getContext(){
        return threadLocal.get();
    }

    private ActionContext(){}

}
