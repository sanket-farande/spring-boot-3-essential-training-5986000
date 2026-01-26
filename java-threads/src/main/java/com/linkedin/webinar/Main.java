package com.linkedin.webinar;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        boolean doStop = false;

        Design d1 = new Design(1, "D1");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for
        // design1

        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable
        // object for design1

        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable
        // object for design1

        // Ch02-Step 7.1 - Start the voting thread for design1

        // Ch02-Step 7.2 - Start the counting thread for design1
        VotingRunnable vr1 = new VotingRunnable(d1);
        Thread t1 = new Thread(vr1);
        t1.start();

        CountingRunnable cr1 = new CountingRunnable(d1);
        Thread t2 = new Thread(cr1);
        t2.start();

        Design d2 = new Design(2, "D2");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for
        // design2

        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable
        // object for design2

        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable
        // object for design2

        // Ch02-Step 7.1 - Start the voting thread for design2

        // Ch02-Step 7.2 - Start the counting thread for design2
        VotingRunnable vr2 = new VotingRunnable(d2);
        Thread t3 = new Thread(vr2);
        t3.start();

        CountingRunnable cr2 = new CountingRunnable(d2);
        Thread t4 = new Thread(cr2);
        t4.start();

        Design d3 = new Design(3, "D3");
        // Ch02-Step 5 - Create an object of the VotingRunnable & CountingRunnable for
        // design3

        // Ch02-Step 6.1 - Create a new Thread instance, passing in the VotingRunnable
        // object for design3

        // Ch02-Step 6.2 - Create a new Thread instance, passing in the CountingRunnable
        // object for design3

        // Ch02-Step 7.1 - Start the voting thread for design3

        // Ch02-Step 7.2 - Start the counting thread for design3
        VotingRunnable vr3 = new VotingRunnable(d3);
        Thread t5 = new Thread(vr3);
        t5.start();

        CountingRunnable cr3 = new CountingRunnable(d3);
        Thread t6 = new Thread(cr3);
        t6.start();

        Thread.sleep(30000);
        // Solution1
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        t5.interrupt();
        t6.interrupt();

        // OR Solution2
        // vr1.doStop = true;
        // cr1.doStop = true;
        // vr2.doStop = true;
        // cr2.doStop = true;
        // vr3.doStop = true;
        // cr3.doStop = true;
    }
}
