package javaBasics.threads.methods;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread t = new Thread(
                () -> {
                    System.out.println("Thread starting...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted.");
                    }
                }
        );

        t.start();
        t.interrupt();
    }
}
