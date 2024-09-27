package com.project;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class TaskLlegir implements Callable<Integer> {

    private ConcurrentHashMap dadesCompartides;

    public TaskLlegir(ConcurrentHashMap dadesCompartides) {
        this.dadesCompartides = dadesCompartides;
    }

    @Override
    public Integer call() throws Exception {
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int saldoFinal=Integer.parseInt(String.valueOf(dadesCompartides.get("Oriol")));
        return saldoFinal;
    }
}
