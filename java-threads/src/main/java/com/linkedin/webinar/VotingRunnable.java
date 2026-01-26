package com.linkedin.webinar;

/**
 * Contains code that represents the voting process.
 * It will keep track of what cake designs are getting votes.
 */

public class VotingRunnable implements Runnable { // Ch02-Step 1 - Implement class by the Runnable interface

    private Design d;
    protected boolean doStop = false; // Will be used in chapter 3 challenge

    public VotingRunnable(Design d) {
        this.d = d;
    }

    // Ch02-Step 2 - Override the run() method
    @Override
    public void run() {
        try {
            System.out.println("Voting started for " + this.d.getName());
            while (!doStop) {
                this.d.getVotes().add(1L);
                Double rdm = Math.random() * 1000;
                Thread.sleep(rdm.intValue());
                // Solution2: Helpful when its not blocked
                if(Thread.interrupted()){
                    doStop = true;
                }
            }
        } catch (InterruptedException e) {
            // Solution1: Helpful when its blocked during sleep
            e.printStackTrace();
            doStop = true;
        } finally {
            System.out.println("Voting ended for " + this.d.getName());
        }
    }
}
