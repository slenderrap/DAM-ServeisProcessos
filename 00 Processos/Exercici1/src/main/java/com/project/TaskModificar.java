package com.project;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class TaskModificar implements Runnable {
    private ConcurrentHashMap<String, Integer> dadesCompartides;

    public TaskModificar(ConcurrentHashMap<String, Integer> dadesCompartides) {
        this.dadesCompartides = dadesCompartides;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int naleatorio = (int) (Math.random() * (1000 - 500) + 500);
        //Modifiquem els diners aleatoriament
        dadesCompartides.put("Oriol", dadesCompartides.get("Oriol") - naleatorio);
        System.out.println("S'ha modificat l'usuari i li queden " + dadesCompartides.get("Oriol") + " euros");


    }
}
