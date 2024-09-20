package main.java.com.project;

public class Task extends Thread implements Runnable{

    private String info;

    public Task(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public void run() {
        System.out.println("copiando archivos");
    }
}
