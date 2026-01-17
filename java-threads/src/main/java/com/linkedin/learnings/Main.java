package com.linkedin.learnings;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! from " + Thread.currentThread().getName());
        
        // With Thread class
        FirstThread thread1 = new FirstThread();
        thread1.start();
        FirstThread thread2 = new FirstThread();
        thread2.start();
        FirstThread thread3 = new FirstThread();
        thread3.start();
        
        // With Runnable
        MyRunnable runnable1 = new MyRunnable();
        Thread thread4 = new Thread(runnable1);
        thread4.start();
    }
}