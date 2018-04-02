package Thread21;

/**
 * Created by Administrator on 2018/4/2.
 */
public class TestVolatile extends Thread {
    public  static int count;
    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }
    @Override
    public void run() {
        addCount();
    }
}

class Run {
    public static void main(String[] args) {
        TestVolatile[] mythreadArray = new TestVolatile[100];
        for (int i = 0; i < 10; i++) {
            mythreadArray[i] = new TestVolatile();
        }

        for (int i = 0; i < 10; i++) {
            mythreadArray[i].start();
        }
    }
}