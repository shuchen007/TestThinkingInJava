package Thread21;

/**
 * @Author sunhao
 * @Description
 * @Date 16:14 2018/4/11
 * @Modified by
 */

public class TestDeadLock {
	private final Object left = new Object();
	private final Object right = new Object();
	public void doTest(String xd) throws InterruptedException {
		synchronized (left){
			long begin = System.currentTimeMillis();
			Thread.sleep(2000);
			System.out.println("begin=" + begin);
			synchronized (right){
				System.out.println("left end");
			}
			System.out.println("end=" + (System.currentTimeMillis() - begin));
		}
	}
	public void doTest1(String xd) throws InterruptedException {
		System.out.println();
		synchronized (right){
			long begin = System.currentTimeMillis();
			System.out.println("begin=" + begin);
			Thread.sleep(2000);
			synchronized (left){
				System.out.println("right end");
			}
			System.out.println("end=" + (System.currentTimeMillis() - begin));
		}
	}
	public static void main(String[] args) {
		final TestDeadLock testDeadLock = new TestDeadLock();
		new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					testDeadLock.doTest("df");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					testDeadLock.doTest1("fdf");
//					td.doTest("fd");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		while(true);
	}
}
