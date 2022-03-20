package ru.grechishkin.spring3.multithreading;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {

    @Override
    public Long call() {
        try {
            System.out.println("Start Runnable: " + Thread.currentThread().getId());
            Thread.sleep(4000);
            System.out.println("Stop Runnable: " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
        return Thread.currentThread().getId();
    }
}
