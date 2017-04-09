package src;

/**
 * Created by evenj on 2017/4/9.
 */
class Bank{
    private int sum;
    public void add(int num){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            sum+=num;
            System.out.println(sum  );
        }
    }
}
class Consumer1 implements Runnable{

    private Bank b=new Bank();

    public void run() {
        for (int i = 0; i < 3; i++) {
            b.add(100);
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        Consumer1 c=new Consumer1();
        Thread t1=new Thread(c);
        Thread t2=new Thread(c);
        t1.start();
        t2.start();

    }
}
