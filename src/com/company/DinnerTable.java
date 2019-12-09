package com.company;

public class DinnerTable {
    private int numberOfSeats;
    private int currentBlocked;

    public DinnerTable(){
    }

    public void finished(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void welcome(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
