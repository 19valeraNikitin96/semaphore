package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
	    DinnerTable table = new DinnerTable();
        Semaphore semaphore = new Semaphore(6, true);
        Random random = new Random();
        for(int i = 1; i <= 15; i++){
               new Thread(new Human(semaphore, table)).start();
            try {
                Thread.sleep(random.nextInt(1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
