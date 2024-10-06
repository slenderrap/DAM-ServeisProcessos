package com.project;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements  Runnable{
    private int numAleatori;
    private final CyclicBarrier cb;

    public Task(CyclicBarrier cb) {
        this.cb = cb;
    }


    public int getNumAleatori() {
        return numAleatori;
    }

    public void setNumAleatori(int numAleatori) {
        this.numAleatori = numAleatori;
    }
    @Override
    public void run() {
        try {


            System.out.println("S'estan recogint les dades de l'examen");
            setNumAleatori((int)(Math.random()*11));
            Thread.sleep(1000);
            System.out.println("El numero generat es: "+numAleatori);
            cb.await();




        } catch (RuntimeException | InterruptedException | BrokenBarrierException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
