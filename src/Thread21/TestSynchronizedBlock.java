package Thread21;

/**
 * @Author sunhao
 * @Description
 * @Date 13:29 2018/4/11
 * @Modified by
 */

public class TestSynchronizedBlock {
	private static TestSynchronizedBlock td = new TestSynchronizedBlock();
	private String x = new String();//全局实例对象，即一个对象。
	public  void otherMethod()
	{
		System.out.println("----------run--otherMethod");
	}
	public void doTest(String xd) throws InterruptedException {
		String xt = new String();
		System.out.println();
		synchronized (x){
			long begin = System.currentTimeMillis();
			System.out.println("begin=" + begin);
			for (int i = 0; i < 100; i++) {
				Thread.sleep(1);
				i++;
				System.out.println("yes =" + Thread.currentThread().getName()+"i="+i);
			}
			System.out.println("end=" + (System.currentTimeMillis() - begin));
		}
	}

	public void doTest2(){
		synchronized (this){
			for (int i = 0; i < 100; i++) {
				i++;
				System.out.println("yes1 =" + Thread.currentThread().getName()+"i="+i);
			}
		}
	}

	public synchronized static void doTestStatic1(){
			for (int i = 0; i < 100; i++) {
				i++;
				System.out.println("yes1 =" + Thread.currentThread().getName()+"i="+i);
			}
	}

	public synchronized static  void doTestStatic2(){
			for (int i = 0; i < 100; i++) {
				i++;
				System.out.println("yes2 =" + Thread.currentThread().getName()+"i="+i);
			}
	}

	public synchronized  void doTestStatic3(){
			for (int i = 0; i < 100; i++) {
				i++;
				System.out.println("yes3 =" + Thread.currentThread().getName()+"i="+i);
			}
	}

	public static void main(String[] args) throws InterruptedException {
		new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					Thread.sleep(10);
					TestSynchronizedBlock.doTestStatic1();
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
					Thread.sleep(10);
					TestSynchronizedBlock.doTestStatic2();
//					td.doTest("fd");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				td.doTest2();
//				td.otherMethod();
			}
		}.start();

		new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					Thread.sleep(10);
					td.doTestStatic3();
//					td.doTest("fd");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				td.doTest2();
//				td.otherMethod();
			}
		}.start();
	}
}
