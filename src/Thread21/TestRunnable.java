package Thread21;

import java.util.Random;

/**
 * Created by Administrator on 2018/3/31.
 */
public class TestRunnable implements Runnable{
    static int i = 1;
    static int x = 1;
    static {
        System.out.println("类加载"+i++);
    }
    TestRunnable(){
        System.out.println("构造！"+i++);
    }
    @Override
    public void run() {
        System.out.println("do"+x++);
    }
    public static void main(String[] args) {
        TestRunnable1 testRunnable = new TestRunnable1();
        try {
            for (int i = 0; i < 3; i++) {
                Thread thread = new Thread(testRunnable);
//                System.out.println(thread.isAlive());
                thread.start();
                System.out.println(thread.getPriority()+thread.getName());
                Thread.sleep((new Random(10).nextInt(5) * 1000));
//                System.out.println(Thread.currentThread().getName() + "在main运行:"+x+Thread.currentThread().isAlive());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class TestRunnable1 implements Runnable {
    static int i = 1;
    int x=1;
    static {
        System.out.println("类加载" + i++);
    }

    TestRunnable1() {
        System.out.println("构造！" + i++);
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep((new Random(10).nextInt(5) * 1000));
            System.out.println(Thread.currentThread().getName() + "在运行:"+x+++Thread.currentThread().isAlive());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
