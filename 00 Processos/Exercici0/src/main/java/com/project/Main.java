package main.java.com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Main {
    public static void main (String ... args) throws InterruptedException {
        ExecutorService exService = Executors.newFixedThreadPool(2);
        Task t1 = new Task("Copia");
        Task t2 = new Task("Xarxa");
        exService.execute(t1);
        exService.execute(t2);
        exService.shutdown();
        exService.awaitTermination(10, TimeUnit.SECONDS);

    }
}

//objectiu: ExecutorService pool -> 2 fils per gestionar 2 tasques en paralel

//1. crear clase Main.java
//2. Definir dos tasques Runnable simulant operacions de manteniment
//3. Utilitzar ExecutorService amb 2 fils, treball paral·lel
//4. tancar executor