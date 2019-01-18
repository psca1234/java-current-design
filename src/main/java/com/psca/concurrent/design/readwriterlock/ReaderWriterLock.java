package com.psca.concurrent.design.readwriterlock;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/18 20:57
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/18 20:57
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReaderWriterLock {
    private int waittingreaders = 0;
    private int readingreaders = 0;
    private int waittingwriters = 0;
    private int writingwriters=0;
    /**
     * true:偏爱写
     * false：偏爱读
     */
    private boolean prefer=true;

    public ReaderWriterLock() {
        this(true);
    }

    public ReaderWriterLock(boolean prefer) {
        this.prefer = prefer;
    }

    public synchronized void readLock() throws InterruptedException {
        this.waittingreaders ++;
        try {
            while(writingwriters >0 || (prefer && waittingreaders >0)){
                this.wait();
            }
            this.readingreaders ++;
        }finally {
            this.waittingreaders --;
        }
    }

    public synchronized void unReadLock(){
        this.readingreaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.waittingwriters++;
        try{
            while(this.readingreaders >0||this.writingwriters>0 ){
                this.wait();
            }
            this.writingwriters ++;
        }finally {
            this.waittingwriters --;
        }
    }

    public synchronized  void unWriteLock(){
        this.writingwriters --;
        this.notifyAll();
    }
}
