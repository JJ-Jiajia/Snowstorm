package src;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by evenj on 2017/4/9.
 */
public class MyThread extends Thread {
    public static class CallableTest implements Callable<String> {

        public String call() throws Exception {
            return "Hello world";
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new CallableTest());
        Future<String> future2 = threadPool.submit(new CallableTest());
        Future<String> future3 = threadPool.submit(new CallableTest());
        try {
            System.out.println("waiting thread to finish");
            System.out.println(future.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
