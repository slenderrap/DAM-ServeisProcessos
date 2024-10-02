package com.project;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
            String text = "";
            System.out.println("\n\nIntrodueix una paraula:");
            Scanner sc = new Scanner(System.in);

            text=sc.nextLine();


            return text;
        });

        CompletableFuture<Integer> future2 = future1.thenApply(text ->{

            int number;
            if (text.length()>5){
                number=1;
            }else{
                number=0;
            }
            return number;
        });

        CompletableFuture<String> future3 = future2.thenApply(number -> {

            String cadena="";
            if (number==1){
                cadena= "Valid: La paraula te mes de 5 lletres";
            }else {
                cadena= "Invalid: La paraula te menys de 5 lletres";
            }

            return cadena;
        });
        //si no volem emmagatzemar el resultat
        future3.thenAccept(System.out::println);

        //si volem emmagatzemar-ho
        String text="";

        try {
            text = future3.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(text);

        //diem que s'esperin per acabar el programa
        future1.join();
        future2.join();
        future3.join();
        System.out.println("Fi del programa");
    }
}