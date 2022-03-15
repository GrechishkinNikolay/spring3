package ru.grechishkin.spring3.multithreading;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("Start Runnable: " + Thread.currentThread().getId());
            Thread.sleep(5000);
            System.out.println("Stop Runnable: " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
        return 42;
    }
}
