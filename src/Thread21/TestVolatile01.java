package Thread21;

/**
 * @Author sunhao
 * @Description
 * @Date 13:41 2018/4/8
 * @Modified by
 */

public class TestVolatile01 {
	private volatile static int a ;

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					a++;
					System.out.println(Thread.currentThread().getName()+a);
				}
			}
		});
		Thread t3 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
//					try {
//						Thread.sleep(1);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					a++;
					System.out.println(Thread.currentThread().getName()+a);
				}
			}
		};
		t1.start();
		t3.start();
		Thread.sleep(5);
		System.out.println("a=" +a);

	}
}
