package javaBasics.threads.methods;

public class ThreadSleep {
    public static void main(String[] args) {
        Thread t = new Thread(
                () -> {
                    try {
                        System.out.println("Thread going to sleep");
                        Thread.sleep(1000);
                        System.out.println("Thread again running...");
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted!");
                    }
                }
        );
        t.start();
    }
}
