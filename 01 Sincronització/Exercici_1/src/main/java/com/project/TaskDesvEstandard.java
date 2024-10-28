package com.project;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TaskDesvEstandard implements Runnable{
    private CyclicBarrier cb;
    private  int[] llistaNums;
    private double desviacioEstandard;
    private int suma;
    private float mitja;
    public TaskDesvEstandard(CyclicBarrier cb, int[] llistaNums) {
        this.cb = cb;
        this.llistaNums =llistaNums;
    }

    public int[] getLlistaNums() {
        return llistaNums;
    }

    public double getDesviacioEstandard() {
        return desviacioEstandard;
    }

    public void setDesviacioEstandard(double desviacioEstandard) {
        this.desviacioEstandard = desviacioEstandard;
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

    @Override
    public void run() {
        System.out.println("Inicio Estandard");
        double dEstandard=0;
        try {
            cb.await();
            cb.await();
            Thread.sleep(5000);
            double sumatori=0;

            for (int i = 0; i < getLlistaNums().length; i++) {
                sumatori += Math.pow(llistaNums[i],2) - 2 * llistaNums[i]*mitja + Math.pow(mitja,2);
            }
            dEstandard = Math.sqrt(sumatori/llistaNums.length);
            System.out.println("En run:"+dEstandard);
            setDesviacioEstandard(dEstandard);
            cb.await();



        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
