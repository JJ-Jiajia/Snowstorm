package src;

/**
 * Created by evenj on 2017/4/9.
 */
class Resources {
    private int count;
    private String name;

    private boolean flag = false;

    public synchronized void getName() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "：消费者..." + this.name + "....");
        flag=false;
        notify();
    }

    public synchronized void setName(String name) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        this.name = name + count;
        System.out.println(Thread.currentThread().getName() + "：生产者..." + this.name);
        flag=true;
        notify();
    }
}

class Producer implements Runnable {
    private Resources r;

    public Producer(Resources r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.setName("面包");
        }
    }
}

class Consumer implements Runnable {
    private Resources r;

    public Consumer(Resources r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.getName();
        }
    }
}

public class ThreadDemo5 {
    public static void main(String[] args) {
        Resources r = new Resources();
        Thread t1 = new Thread(new Producer(r));
        Thread t2 = new Thread(new Consumer(r));
        t1.start();
        t2.start();
    }
}
