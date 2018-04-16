package Thread21;

import java.util.Hashtable;

/**
 * Created by Administrator on 2018/4/13.
 */
public class TestYield {

    public static void main(String[] args) {
        Thread threada = new ThreadA();
        Thread threadb = new ThreadB();
        // 设置优先级:MIN_PRIORITY最低优先级1;NORM_PRIORITY普通优先级5;MAX_PRIORITY最高优先级10
        threada.setPriority(Thread.MIN_PRIORITY);
        threadb.setPriority(Thread.MAX_PRIORITY);

        threada.start();
        threadb.start();
        new Hashtable();
    }
}

class ThreadA extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadA--" + i);
//            Thread.yield();
        }
    }
}

class ThreadB extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadB--" + i);
            Thread.yield();
        }
    }
}
