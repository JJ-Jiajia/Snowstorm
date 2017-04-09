package src;

/**
 * Created by evenj on 2017/4/9.
 */
class DeathLock implements Runnable {
    private final Object obj1 = new Object();
    private final Object obj2 = new Object();
    boolean flag = true;

    public void run() {
        if (flag) {
            System.out.println("1");
            synchronized (obj1) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    for (; ; ) {
                        System.out.println("yoyo1");
                    }
                }
            }
        } else {
            System.out.println("2");
            synchronized (obj2) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (obj1) {
                    for (; ; ) {
                        System.out.println("yoyo2,");
                    }
                }
            }
        }

    }
}

public class ThreadDemo4 {
    public static void main(String[] args) {
        DeathLock dl = new DeathLock();
        Thread t1 = new Thread(dl);
        Thread t2 = new Thread(dl);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dl.flag = false;
        t2.start();
    }
}
