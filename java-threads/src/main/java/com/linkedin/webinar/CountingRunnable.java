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
        System.out.println("Counting started for " + this.d.getName());
        this.totalVotes = this.d.getVotes().stream().mapToLong(Long::longValue).sum();
        System.out.println("Counting ended for " + this.d.getName() + " " + this.totalVotes);
    }
}
