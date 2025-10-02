package javaBasics.threads.methods;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Worker thread finished!");
            } catch (InterruptedException e) {}
        });

        t.start();
        System.out.println("Main waiting for worker...");
        t.join();
        System.out.println("Main resumes after worker");
    }
}
