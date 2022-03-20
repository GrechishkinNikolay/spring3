package ru.grechishkin.spring3.multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {

    @Override
    public Long call() {
        try {
            System.out.println("Start Runnable: " + LocalDateTime.now());
            Thread.sleep(4000);
            System.out.println("Stop Runnable: " + LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
        return Thread.currentThread().getId();
    }

    @Override
    public String toString() {
        return "REJECTED";
    }
}
