package Thread21;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2018/4/14.
 */
public class TestThreadPool {
    private static Lock lock = new ReentrantLock(true);
    public static void main(String[] args)
    {

        long startTime = System.currentTimeMillis();
        final List<Integer> l = new ArrayList<Integer>();//Vector线程安全，ArrayList线程不安全。
        Collections.sort(l);
        ThreadPoolExecutor tp = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(20000));
        final Random random = new Random();
//        for (int i = 0; i < 20000; i++)
//        {
//            tp.execute(new Runnable()
//            {
//                public void run()
//                {
//                    lock.lock();
////                    synchronized (this){
//                        l.add(random.nextInt());
////                    }
//                    lock.unlock();
//                }
//            });
//        }
//        tp.shutdown();
//        try
//        {
//            tp.awaitTermination(1, TimeUnit.DAYS);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }

        for (int i = 0; i < 20000; i++) {
            Thread thread = new Thread() {
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }
}
