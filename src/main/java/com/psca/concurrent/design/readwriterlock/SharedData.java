package com.psca.concurrent.design.readwriterlock;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/18 21:13
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/18 21:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SharedData {
    private char [] buff;
    private ReaderWriterLock lock = new ReaderWriterLock();
    public SharedData(int  size) {
        this.buff = new char[size];
        for (int i = 0; i < size; i++) {
            this.buff[i] = '*';
        }
    }
    public char[] readFromShardData() throws InterruptedException {
        try {
            lock.readLock();
            char[] resultBuff = this.doRead();
            return resultBuff;
        }finally {
            lock.unReadLock();
        }
    }

    private char[] doRead() {
        char [] newBuff = new char[buff.length];
        for(int i=0;i<buff.length;i++){
            newBuff[i] =buff[i];
            slowly(50);
        }
        return newBuff;
    }

    public void write(char c) throws InterruptedException {
        try{
            lock.writeLock();
            this.doWrite(c);
        }finally {
            lock.unWriteLock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buff.length; i++) {
            buff[i] = c;
            slowly(10);
        }
    }

    private void slowly(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }

}
