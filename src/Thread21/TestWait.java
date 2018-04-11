package Thread21;

/**
 * @Author sunhao
 * @Description
 * @Date 16:49 2018/4/11
 * @Modified by
 */

public class TestWait {
	static int a;
	public void doTest(String xd) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			a++;
			Thread.sleep(1000);
			System.out.println(a);
		}
	}
	public void doTest1(String xd) throws InterruptedException {
		System.out.println("start");
		if (6==a){
			System.out.println("begin=" + a);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		final TestWait testWait = new TestWait();
		new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					while (true){
						testWait.doTest1("dfdf");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		Thread.sleep(1000);
		new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					testWait.doTest("fdsf");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
