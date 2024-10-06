package com.project;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

    ExecutorService es = Executors.newFixedThreadPool(3);
    CyclicBarrier cb = new CyclicBarrier(3);

    Task tasca1 = new Task(cb);
    Task tasca2 = new Task(cb);
    Task tasca3 = new Task(cb);

    es.submit(tasca1);
    es.submit(tasca2);
    es.submit(tasca3);
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }




    int num1 = tasca1.getNumAleatori();
    int num2 = tasca2.getNumAleatori();
    int num3 = tasca3.getNumAleatori();




    int numFinal = num1 + num2 + num3;
    double mitja = Math.round(((double) numFinal /3)*100.0)/100.0;


    System.out.println("La nota final es: "+mitja);
    es.shutdown();
    if (es.isShutdown()){
        System.exit(0);
    }


    }
}