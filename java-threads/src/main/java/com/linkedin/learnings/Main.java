package com.linkedin.learnings;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Hello world! from " + Thread.currentThread().getName());
        
        // With Thread class
        FirstThread thread1 = new FirstThread();
        // thread1.start();
        FirstThread thread2 = new FirstThread();
        // thread2.start();
        FirstThread thread3 = new FirstThread();
        // thread3.start();
        
        // With Runnable
        MyRunnable runnable1 = new MyRunnable();
        Thread thread4 = new Thread(runnable1);
        // thread4.start();

        SleepThread thread5 = new SleepThread();
        thread5.start();
        
        // Approach 1
        // Thread.sleep(3000);
        // // Inturrupting a blocking thread, sets inturrupt status to true
        // thread5.interrupt();
        // System.out.println("Status from main thread " + thread5.isInterrupted());
        
        // Approach 2
        thread5.interrupt();
        Thread.sleep(3000);
        System.out.println("Status from main thread " + thread5.isInterrupted());

        // Syncronization with Threads
        int[] marks = new int[10];
        MarksJoinThread mt = new MarksJoinThread(marks);
        AverageThread at = new AverageThread(marks);
        mt.start();
        // ensure mt completes before starting at
        mt.join();
        at.start();
    }
}