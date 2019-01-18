package com.psca.concurrent.design.readwriterlock;

import java.util.Random;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/18 21:31
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/18 21:31
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WriteWorker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData data;

    private final String filler;

    private int index = 0;

    public WriteWorker(SharedData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length())
            index = 0;
        return c;
    }
}
