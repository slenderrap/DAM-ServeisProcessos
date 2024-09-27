package com.project;

import lombok.EqualsAndHashCode;

import java.util.concurrent.ConcurrentHashMap;

public class TaskEscriure implements Runnable{
    private ConcurrentHashMap<String, Integer> dadesCompartides;

    public TaskEscriure(ConcurrentHashMap<String, Integer> dadesCompartides) {
        this.dadesCompartides = dadesCompartides;
    }

    @Override
    public void run() {
        int naleatorio = (int) (Math.random() * (2500 - 1000) + 1000);
        String nom = "Oriol";
        //S'introdueix un usuari amb diners

        dadesCompartides.put(nom,naleatorio);
        System.out.println("S'ha generat l'usuari "+nom +" amb "+ naleatorio + " euros" );





    }
}
