package com.linkedin.learnings;

public class AverageThread extends Thread{
    private final int[] marks;

    public AverageThread(int[] marks){
        this.marks = marks;
    }

    @Override
    public void run(){
        int size = this.marks.length;
        int sum = 0;
        for(int i=0; i< size; ++i){
            sum+=this.marks[i];
        }
        System.out.println("Average of marks: " + sum/size);
    }

}
