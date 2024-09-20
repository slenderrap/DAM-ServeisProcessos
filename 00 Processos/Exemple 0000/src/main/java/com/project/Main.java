package com.project;

class Main {
	public static void main (String ... args){
        new ThreadDemo("Info pel thread").start();
		
	
		new Thread(new Task("Info per la tasca 0"), "Thread 0").start();
		
		new Thread(new Task("Info per la tasca 1"), "Thread 1").start();
	}
}
//objectiu: ExecutorService pool -> 2 fils per gestionar 2 tasques en paralel

//1. crear clase Main.java
//2. Definir dos tasques Runnable simulant operacions de manteniment
//3. Utilitzar ExecutorService amb 2 fils, treball paral·lel
//4. tancar executor
