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
				for (int i = 0; i < 1000; i++) {
					a++;
				}
			}
		});
		Thread t3 = new Thread(){
			@Override
			public void run() {
				super.run();
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					a++;
				}
			}
		};
		t1.start();
		t3.start();
		Thread.sleep(5);
		System.out.println("a=" +a);

	}
}
