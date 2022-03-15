package ru.grechishkin.spring3.multithreading;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Start Runnable: " + Thread.currentThread().getId());
            Thread.sleep(3000);
            System.out.println("Stop Runnable: " + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
    }
}
