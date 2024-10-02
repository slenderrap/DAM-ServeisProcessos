package com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {
	public static void main (String ... args){

		//instanciem l'executor amb 2 fils
		ExecutorService exServive = Executors.newFixedThreadPool(2);

		//creem els fils amb la tasca assignada
		Thread tasca1= new Thread(new Task("tarea 1"));
		Thread tasca2= new Thread(new Task("tarea 2"));

		//executem els dos fils
		exServive.execute(tasca1);
		exServive.execute(tasca2);

		//tanquem l'executor
		exServive.shutdown();



	}
}
//objectiu: ExecutorService pool -> 2 fils per gestionar 2 tasques en paralel

//1. crear clase Main.java
//2. Definir dos tasques Runnable simulant operacions de manteniment
//3. Utilitzar ExecutorService amb 2 fils, treball paral·lel
//4. tancar executor
