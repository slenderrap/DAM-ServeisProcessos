package com.project;

import java.util.concurrent.Semaphore;

public class WebPage implements Runnable{
    private final Semaphore semafor;
    private final int id;

    public WebPage(Semaphore semafor, int id) {
        this.semafor = semafor;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("l'usuari "+id+" es vol connectar");
                semafor.acquire();
                System.out.println("l'usuari "+id+" s'ha connectat");
                Thread.sleep(5000);
                semafor.release();
                System.out.println("l'usuari "+id+" s'ha desconnectat");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
