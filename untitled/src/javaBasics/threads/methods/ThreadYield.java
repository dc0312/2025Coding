package javaBasics.threads.methods;

/**
yield()

Suggests to the scheduler that the current thread is willing to pause and give CPU to other threads of equal priority.

It’s only a hint — may or may not happen.

Keeps thread in RUNNABLE (not WAITING).
*/
public class ThreadYield {
    public static void main(String[] args) {
        Runnable task = () -> {
          for(int i =0; i <5;i++){
              System.out.println(Thread.currentThread().getName()+" - "+i);
              Thread.yield();
          }
        };

        new Thread(task, "T1").start();
        new Thread(task, "T2").start();
    }
}
