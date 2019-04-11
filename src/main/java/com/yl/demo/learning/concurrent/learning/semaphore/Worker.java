package com.yl.demo.learning.concurrent.learning.semaphore;

import java.util.concurrent.Semaphore;

public class Worker extends Thread {
    private Semaphore semaphore;
    private int workNo;
    public Worker (int workNo, Semaphore semaphore) {
        this.workNo = workNo;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start to acquire machine permission");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is holding semaphore");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " work finished");
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " released semaphore");
            System.out.println(Thread.currentThread().getName() + " go to do something else");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
