package com.project;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {

        System.out.println("Inici del programa");
        int[] llistaNums = new int[10];
        for (int i = 0; i < llistaNums.length; i++) {
            llistaNums[i] = (int)(Math.random()*100)+1;

        }
        ExecutorService es = Executors.newFixedThreadPool(3);
        CyclicBarrier cb = new CyclicBarrier(3);

        TaskSuma suma = new TaskSuma(cb,llistaNums);
        TaskMitja mitja = new TaskMitja(cb,llistaNums);
        TaskDesvEstandard dEstandard = new TaskDesvEstandard(cb,llistaNums);

        es.execute(suma);
        es.execute(mitja);
        es.execute(dEstandard);

        es.shutdown();
        System.out.println("Fi del programa");



    }
}