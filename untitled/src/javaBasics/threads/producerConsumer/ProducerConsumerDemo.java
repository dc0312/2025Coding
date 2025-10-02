package javaBasics.threads.producerConsumer;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable{
    private final List<Integer> queue;
    private final int LIMIT;

    Producer(List<Integer> queue, int LIMIT){
        this.queue = queue;
        this.LIMIT = LIMIT;
    }


    @Override
    public void run() {
        int value =0;
        while(true) {
            synchronized (queue){
                while (queue.size() == LIMIT) {
                    try {
                        System.out.println("Queue full! Producer waiting...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Produced "+ value);
                queue.add(value++);
                queue.notifyAll();
                try {
                    Thread.sleep(500); // simulate production time
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}

class Consumer implements Runnable{

    private final List<Integer> queue;

    Consumer(List<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){
                while(queue.isEmpty()){
                    try {
                        System.out.println(Thread.currentThread().getName() + " waiting (queue empty)...");
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int val = queue.remove(0);
                System.out.println(Thread.currentThread().getName()+" consumed "+val);
                queue.notifyAll();
            }
        }
    }
}

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>();
        int LIMIT = 5;
        Thread producer = new Thread(new Producer(queue,LIMIT), "Producer1");
        Thread consumer1 = new Thread(new Consumer(queue), "Consumer 1");
        Thread consumer2 = new Thread(new Consumer(queue), "Consumer 2");

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
