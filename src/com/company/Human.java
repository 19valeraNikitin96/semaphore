package com.company;

import java.util.concurrent.Semaphore;

public class Human implements Runnable {
    private static int count = 0;
    private int number;
    private Semaphore semaphore;
    private DinnerTable table;

    public Human(Semaphore semaphore, DinnerTable dinnerTable){
        number = ++count;
        this.semaphore = semaphore;
        table = dinnerTable;
    }

    @Override
    public void run() {
        System.out.println("Human with number "+number+" wants to sit down");
        boolean await = false;
        try {
            if(!semaphore.tryAcquire()){
                await = true;
                System.out.println("- F*ck! Will have to wait... - said human with number "+number);
            }
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(await)
            System.out.println("- At last! - said human with number "+number);
        System.out.println("Human with number "+number+" sat");
        synchronized (table){
            table.welcome();
            table.finished();
        }
        semaphore.release();
        System.out.println("Human with number "+number+" left");
    }
}
