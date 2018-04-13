package Thread21;

/**
 * Created by Administrator on 2018/3/31.
 */
public class TestThread extends Thread {
    static int i = 1;
    static int x = 1;

    //    static {
//        System.out.println("类加载"+i++);
//    }
//    TestThread(){
//        System.out.println("构造"+i++);
//    }
    @Override
    public void run() {
        System.out.println("do=" + x++);
    }


    public static void main(String[] args) throws InterruptedException {
//        MyThread03 mt = new MyThread03();
//        System.out.println(Thread.currentThread().getName()+"--begin == " + mt.isAlive());
//        mt.setName("-sunT-");
//        mt.start();
////        mt.run();
////        Thread.sleep(100);//睡眠0.1s保证mt中的线程执行完。
//        System.out.println(Thread.currentThread().getName()+"--end == " + mt.isAlive());
//        Thread.currentThread().interrupt();
//        System.out.println("是否停止1？" + Thread.interrupted());
//        System.out.println("是否停止2？" + Thread.interrupted());
//        System.out.println("end!");
        try
        {
            Thread mt = new TestThread1();
//            mt.setDaemon(true);//设置为守护线程。//设置为守护线程，5s后必定结束。
            mt.start();
//            Thread.sleep(5000);
            mt.join(5000);//等待线程销毁时，再执行。内部调用的是wait()方法
            System.out.println("dd"+Thread.currentThread().getName());
            mt.interrupt();
            System.out.println("我离开thread对象再也不打印了，我停止了！");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

class TestThread2 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"run = " + this.isAlive());
    }
}

class TestThread1 extends Thread{
    @Override
    public void run(){
        int i = 0;
        try
        {
            while (true){
                System.out.println("do1="+i++);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyThread03 extends Thread
{
    public void run()
    {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 5; i++)
        {
//            Thread.yield();
            count = count + i + 1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "毫秒！");
    }
}
