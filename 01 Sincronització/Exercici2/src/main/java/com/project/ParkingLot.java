package com.project;

import java.util.concurrent.Semaphore;

public class ParkingLot implements Runnable{
    private final Semaphore semafor;
    private final int id;

    public ParkingLot(Semaphore semafor, int id) {
        this.semafor = semafor;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("El cotxe amb id "+id+" esta esperant per entrar");

            semafor.acquire();
            System.err.println("El cotxe amb id "+id+" ja ha entrat");
            Thread.sleep((int)(Math.random()*8000)+2000);
            semafor.release();
            System.out.println("\nEl cotxe amb id "+id+" ja ha sortit\n");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
