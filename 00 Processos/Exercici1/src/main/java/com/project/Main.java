package com.project;



import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) throws InterruptedException{

		//Definir un ConcurrentHashMap per compartir informacio entre tasques
		//Es similar a un diccionari key:value
		ConcurrentHashMap<String, Integer> dadesCompartides = new ConcurrentHashMap<>();
		//definir tres tasques: 1. Runnable introdueixi dades recepció d'una operació bancària.
		TaskEscriure tascaEscriure = new TaskEscriure(dadesCompartides);
		//2. Runnable modifiqui dades simulant operacio d'interesos
		TaskModificar tascaModificar = new TaskModificar(dadesCompartides);
		//3. Calleble llegeixi dades modificades i retorni un resultat final com un saldo actualitzat
		TaskLlegir tascallegir= new TaskLlegir(dadesCompartides);
		Callable<Integer> llegir = tascallegir;

		Thread fil1 = new Thread(tascaEscriure);
		Thread fil2 = new Thread(tascaModificar);




		//Utilitzar ExecutorService amb (newFixedThreadPool(3))
		ExecutorService exService = Executors.newFixedThreadPool(3);
		exService.execute(fil1);
		exService.execute(fil2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		Future<Integer> fil3 = exService.submit(llegir);
		//para ejecutar un calleable se necesita el submit
        try {
            int num = Integer.parseInt(String.valueOf(fil3.get()));
			//recull resultat i imprimeix per pantalla simulant presentacio final de operacio bancaria al client
			System.out.println("El saldo que li queda es: " + num);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		//tancar l'executor
		exService.shutdown();

	}
	
}
