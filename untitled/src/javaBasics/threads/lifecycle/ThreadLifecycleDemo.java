package javaBasics.threads.lifecycle;

public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("T1 acquired lock, going to wait...");
                    lock.wait(); // moves to WAITING
                    System.out.println("T1 resumed after notify");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T2 acquired lock, notifying...");
                lock.notify(); // wakes T1
            }
        });

        System.out.println("Before start: " + t1.getState()); // NEW
        t1.start();
        Thread.sleep(100); // give time for t1 to enter wait
        System.out.println("T1 state after wait: " + t1.getState()); // WAITING

        t2.start();
        t1.join();
        System.out.println("After completion: " + t1.getState()); // TERMINATED
    }
}

