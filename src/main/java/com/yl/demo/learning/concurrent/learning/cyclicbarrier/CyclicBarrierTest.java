package com.yl.demo.learning.concurrent.learning.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {

        CyclicBarrierTest.run();
    }

    protected static void run () {
        int threadNum = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum);

        for (int i=0; i<threadNum; i++) {
            final int threadI = i;
            System.out.println("创建线程" + i);
            new Thread(() -> {
                try {
                    //System.out.println(Thread.currentThread().getName() + "开始等待");

                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    //睡眠3秒来模拟线程的执行过程
                    Thread.sleep(3000);

                    System.out.println(Thread.currentThread().getName() + "执行结束");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e1) {
                    e1.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "来到后续执行");
            }).start();
        }

        System.out.println("主线程开始执行");

    }
}
