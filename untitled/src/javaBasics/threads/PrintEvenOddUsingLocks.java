package javaBasics.threads;

import java.util.concurrent.atomic.AtomicInteger;

// Task to print even numbers
class EvenTask implements Runnable {
    private final Object lock;
    private final AtomicInteger counter;
    private final int max;

    public EvenTask(Object lock, AtomicInteger counter, int max) {
        this.lock = lock;
        this.counter = counter;
        this.max = max;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    while (counter.get() % 2 != 0 && counter.get() <= max) {
                        lock.wait();
                    }
                    if (counter.get() > max) {
                        lock.notifyAll();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter.getAndIncrement());
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("EvenTask interrupted: " + e.getMessage());
                }
            }
        }
    }
}

// Task to print odd numbers
class OddTask implements Runnable {
    private final Object lock;
    private final AtomicInteger counter;
    private final int max;

    public OddTask(Object lock, AtomicInteger counter, int max) {
        this.lock = lock;
        this.counter = counter;
        this.max = max;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    while (counter.get() % 2 != 1 && counter.get() <= max) {
                        lock.wait();
                    }
                    if (counter.get() > max) {
                        lock.notifyAll();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + counter.getAndIncrement());
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("OddTask interrupted: " + e.getMessage());
                }
            }
        }
    }
}

public class PrintEvenOddUsingLocks {
    public static void main(String[] args) {
        final Object lock = new Object();
        final AtomicInteger counter = new AtomicInteger(1);
        final int max = 20;

        Thread evenThread = new Thread(new EvenTask(lock, counter, max), "EvenThread");
        Thread oddThread = new Thread(new OddTask(lock, counter, max), "OddThread");

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
    }
}