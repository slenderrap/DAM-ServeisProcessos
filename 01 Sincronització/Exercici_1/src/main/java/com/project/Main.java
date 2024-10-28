package com.project;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int[] llistaNums = new int[10];
        for (int i = 0; i < llistaNums.length; i++) {
            llistaNums[i] = (int)(Math.random()*100)+1;

        }
        ExecutorService es = Executors.newFixedThreadPool(3);
        CyclicBarrier cb = new CyclicBarrier(3);

        TaskSuma suma = new TaskSuma(cb,llistaNums);
        TaskMitja mitja = new TaskMitja(cb,llistaNums);
        TaskDesvEstandard dEstandard = new TaskDesvEstandard(cb,llistaNums);

        es.submit(suma);
        es.submit(mitja);
        es.submit(dEstandard);

        try{
            cb.await();
            cb.await();
            cb.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        int sumatori = suma.getSuma();
        mitja.setSuma(sumatori);
        float mitjana = mitja.getMitja();
        dEstandard.setSuma(sumatori);
        dEstandard.setMitja(mitjana);
        double desvEstandar = dEstandard.getDesviacioEstandard();

        System.out.println(sumatori);
        System.out.println("aqui s "+suma.getSuma());
        System.out.println(mitjana);
        System.out.println("aqui m "+mitja.getMitja());
        System.out.println(desvEstandar);
        System.out.println("aqui e "+dEstandard.getDesviacioEstandard());
        es.shutdown();




    }
}