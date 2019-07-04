package ru.itis.thread;

public class MainThread implements Runnable {
    int id;
    String name;

    public MainThread(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < id; i++) {
            Main.global++;
            System.out.println(name);
        }
    }
}
