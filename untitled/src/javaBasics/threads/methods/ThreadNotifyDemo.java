package javaBasics.threads.methods;

public class ThreadNotifyDemo {

    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName() +" waiting...");
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "Resumed...");
            }

        };

        System.out.println("Main Thread running...");
        Thread t1 = new Thread(task,"Thread 1 ");
        Thread t2 = new Thread(task,"Thread 2 ");

        t1.start();
        t2.start();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}


        synchronized (LOCK){
            System.out.println("Main Thread notifying...");
            //LOCK.notify();
            LOCK.notifyAll();
            /**
            * notify() → Useful when only one waiting thread should proceed, e.g., a single consumer waiting for work.
             * notifyAll() → Useful when multiple threads are waiting and we don’t know which one should proceed,
             * e.g., multiple consumers waiting on a shared queue.
            * */
        }



    }
}
