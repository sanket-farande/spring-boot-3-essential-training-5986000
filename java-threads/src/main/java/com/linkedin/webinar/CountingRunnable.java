package com.linkedin.webinar;

/**
 * Contains code that represents the counting process.
 * It will keep counting the number of votes each cake design is getting.
 */

public class CountingRunnable implements Runnable { // Ch02-Step 3 - Implement class by the Runnable interface

    private Design d;
    protected boolean doStop = false; // Will be used in chapter 3 challenge
    private Long totalVotes = 0L;

    public CountingRunnable(Design d) {
        this.d = d;
    }

    // Ch02-Step 4 - Override the run() method
    @Override
    public void run() {
        try {
            System.out.println("Counting started for " + this.d.getName());
            while (!doStop) {
                this.totalVotes = this.d.getVotes().stream().mapToLong(Long::longValue).sum();
                System.out.println("Counting for " + this.d.getName() + " " + this.totalVotes);
                Thread.sleep(2000);
                // Solution2: Helpful when its not blocked
                if(Thread.interrupted()){
                    doStop = true;
                }            }
        } catch (InterruptedException e) {
            // Solution1: Helpful when its blocked during sleep
            e.printStackTrace();
            doStop = true;
        } finally {            
            System.out.println("Counting ended for " + this.d.getName());
        }
    }
}
