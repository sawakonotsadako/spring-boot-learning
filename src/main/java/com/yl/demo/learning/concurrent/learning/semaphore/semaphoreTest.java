package com.yl.demo.learning.concurrent.learning.semaphore;


import java.util.concurrent.Semaphore;

public class semaphoreTest {
    public static void main(String[] args) {
        int machineAmt = 3;
        Semaphore semaphore = new Semaphore(machineAmt);
        for (int i=0; i<5; i++)
            new Worker(i, semaphore).start();


        System.out.println("main thread begin to work..");
    }

}
