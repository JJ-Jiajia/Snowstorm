package src;

/**
 * Created by evenj on 2017/4/9.
 */
class Tickets implements Runnable {
    private static int tickets = 100;
    boolean flag = true;

    public void run() {
        if (flag) {
            while (true) {
                synchronized (this) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + "obj:" + tickets--);
                    }
                }
            }
        } else {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sale();
            }
        }
    }

    private static synchronized void sale() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "sale:" + tickets--);
        }
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        Tickets ti = new Tickets();
        Thread t1 = new Thread(ti);
        Thread t2 = new Thread(ti);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ti.flag = false;
        t2.start();

    }
}
