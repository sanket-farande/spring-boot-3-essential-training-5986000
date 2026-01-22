package com.linkedin.learnings;

public class SleepThread extends Thread {

    @Override
    public void run() {
        System.out.println("From thread which is about to sleep");
        for (int i = 1; i <= 100; ++i) {
            System.out.println(i);

            // Approach 1: Inturrupt handling with Instance method
            // try {
            //     // blocking method : which inturrupted threads status is cleared by setting it to false and throws exception
            //     Thread.sleep(1000);
            // } catch (Exception e) {
            //     System.out.println("Status from task thread "+Thread.currentThread().isInterrupted());
            //     break;
            // }

            // Approach 2: Inturrupt handling with static method
            System.out.println("Status from task thread "+Thread.currentThread().isInterrupted());
            if(Thread.interrupted()){
                break;
            }
        }
    }
}
