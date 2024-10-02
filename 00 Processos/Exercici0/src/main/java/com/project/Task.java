package com.project;

class Task implements Runnable {

    private String tasca;

    public Task(String tasca) {
        this.tasca = tasca;
    }

    @Override
    public void run(){
        //declarem un numero aleatori entre 20 y 5 per simular la copia d'arxius
        int naleatorio = (int) (Math.random() * (20 - 5) + 5);
        //informem del que es fara
        System.out.println("Se copiaran "+naleatorio+" archivos de la "+ tasca);

        //fem la simulacio de copia d'arxius
        for (int i=0; i<naleatorio;i++){
            System.out.println("Copiando el archivo numero "+ (i + 1)+" de la "+ tasca);
        }

        //indiquem que ha finalitzat la tasca
        System.out.println("La copia ha finalizado correctamente para "+ tasca);

    }
}
