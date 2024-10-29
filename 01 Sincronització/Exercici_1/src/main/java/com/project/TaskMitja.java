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
        mitja = 0;
        try {
            Thread.sleep(5000);
            for (int i = 0; i < llista.length; i++) {
                suma +=llista[i];
            }
            mitja =  (float) Math.round((float) (100 * suma) / llista.length) /100;
            setMitja(mitja);
            cb.await();
            System.out.println("La mitja es: "+ mitja);

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
