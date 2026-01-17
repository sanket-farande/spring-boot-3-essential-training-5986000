package com.linkedin.learnings;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<=5; ++i){
            System.out.println(this.getClass().getSimpleName() + "_"+ i);
        }
    }

}
