package ru.itis.thread;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    static int global;

    public static void main(String[] args) throws InterruptedException {
        Collection<Thread> threads = new ArrayList<>();
        for (int i = 10; i < 12; i++) {
            Thread thread = new Thread(new MainThread(i, String.valueOf(i)));
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        System.out.println(Main.global);
    }
}
