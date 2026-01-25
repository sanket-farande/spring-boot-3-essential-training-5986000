package com.linkedin.learnings;

public class MarksJoinThread extends Thread{
    private final int[] marks;

    public MarksJoinThread(int[] marks){
        this.marks = marks;
    }

    @Override
    public void  run(){
        for(int i=0; i< 10; ++i){
            Double rdm = Math.random() * 100;
            this.marks[i] = rdm.intValue();
            System.out.println("Marks entered: "+this.marks[i]);
            try {                
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
