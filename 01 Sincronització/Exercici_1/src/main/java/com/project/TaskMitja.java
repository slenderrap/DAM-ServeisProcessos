package com.project;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TaskMitja implements  Runnable{
    private int suma;
    private int[] llista;
    private float mitja;
    private CyclicBarrier cb;

    public TaskMitja(CyclicBarrier cb, int[] llista) {
        this.cb = cb;
        this.llista = llista;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public float getMitja() {
        return mitja;
    }

    public void setMitja(float mitja) {
        this.mitja = mitja;
    }

    public int[] getLlista() {
        return llista;
    }

    @Override
    public void run() {
        System.out.println("inici mitja");
        float mitjana = 0;
        try {
            cb.await();
            Thread.sleep(5000);
            mitjana = (float) suma /getLlista().length;
            setMitja(Math.round(mitjana));
            cb.await();
            cb.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
