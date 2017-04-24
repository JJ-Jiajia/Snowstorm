package src;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by evenj on 2017/4/9.
 */
public class MyThread2 implements Runnable {
    private int tickets = 100;

    private Object lock= new Object();

    public void run() {
//        int tickets = 100;
        while (true) {
            synchronized (lock) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "..........." + tickets--);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread2 t = new MyThread2();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        Thread t5 = new Thread(t);
        Thread t6 = new Thread(t);
        Thread t7 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}
