package Thread21;

/**
 * Created by Administrator on 2018/4/2.
 */
public class TestVolatile extends Thread {
    private volatile boolean isRunning = true;
    public static long count;

    public void setRunning(boolean running) {
        isRunning = running;
    }
    private  void  addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count +this.getName());//最终打印的值并非10000，volatile对所有线程可见。
    }
    @Override
    public void run() {
//        System.out.println("进入到run方法中了");
//         while (isRunning == true) {
//             }
//         System.out.println("线程执行完成了");
        addCount();
    }
}

class Run {
    public static void main(String[] args) throws InterruptedException {
        TestVolatile tv = new TestVolatile();
        TestVolatile[] mythreadArray = new TestVolatile[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new TestVolatile();
            mythreadArray[i].start();
        }
//        for (int i = 0; i < 100; i++) {
//
//        }
//        tv.start();
//        Thread.sleep(1000);
//        tv.setRunning(false);
    }
}