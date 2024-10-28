package com.project;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TaskSuma implements Runnable {
    private int[] numbers ;
    private int suma;
    private CyclicBarrier cb;



    public TaskSuma(CyclicBarrier cb,int[] numbers) {
        this.cb = cb;
        this.numbers = numbers;
    }


    public int getSuma() {
        return this.suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int[] getNumbers() {
        return numbers;
    }

    @Override
    public void run() {
        System.out.println("Inici sumatori");
        int sumatori=0;
        try {
            Thread.sleep(5000);
            for (int i = 0; i <getNumbers().length; i++) {
                sumatori += getNumbers()[i];
            }
            setSuma(sumatori);
            System.out.println("Suma proces1 "+getSuma());
            cb.await();
            System.out.println("Suma proces2 "+getSuma());
            cb.await();
            System.out.println("Suma proces3 "+getSuma());
            cb.await();
            System.out.println("Suma proces4 "+getSuma());


        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }


    }
}
