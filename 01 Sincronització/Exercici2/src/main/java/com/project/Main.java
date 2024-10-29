package com.project;

import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Inici programa");
        Semaphore semafor = new Semaphore(2);
        ExecutorService es= Executors.newFixedThreadPool(8);
        for (int i = 0; i < 8; i++) {
            es.execute(new ParkingLot(semafor,i));
        }


        es.shutdown();
        System.out.println("Fi del programa");











    }
}