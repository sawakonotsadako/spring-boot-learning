package com.yl.demo.learning.concurrent.learning.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main (String[] args) {

        CountDownLatchTest.run();

    }

    protected static void run () {
        int threadNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i=0; i<threadNum; i++) {
            final int threadI = i + 1;
            new Thread(() -> {
                System.out.println("thread " + threadI + " start!");

                // 睡眠2秒来模拟线程的执行过程
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread " + threadI + " finished!");

                countDownLatch.countDown();

            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadNum + " threads finished！");

    }
}
