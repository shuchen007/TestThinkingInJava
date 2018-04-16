package Thread21;

/**
 * @Author sunhao
 * @Description
 * @Date 14:13 2018/4/8
 * @Modified by
 */

public class TestSynchronized {
//	static TestSynchronized te = new TestSynchronized();
	static TestSynchronized te1 = new TestSynchronized();
	public  int count;
	public  int count1;
	private synchronized void  addCount() throws InterruptedException {
//		测试抛异常时切换到另一个线程
//		System.out.println("Enter ThreadDomain17.testMethod, currentThread = " +
//				Thread.currentThread().getName());
//		long l = Integer.MAX_VALUE;
//		while (true)
//		{
//			long lo = 2 / l;
//			l--;
//		}
//		测试抛异常时切换到另一个线程，end
//		Thread.sleep(300);
		Thread.yield();
		for (int i = 0; i < 10; i++) {
//
//
			count++;
			System.out.println("cou1"+Thread.currentThread().getName());
		}
	}
	private synchronized void  addCount1() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			count1++;
			System.out.println("cou2"+Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TestSynchronized te = new TestSynchronized();
//		final TestSynchronized te1 = new TestSynchronized();
//		Thread t1 = new Thread(){
		class MyThread extends Thread{
			private TestSynchronized te;
			MyThread(TestSynchronized te){
				this.te = te;
			}
			@Override
			public void run() {
				super.run();
//				for (int i = 0; i < 5; i++) {
					try {
						System.out.println(this.getName()+Thread.currentThread().getName()+this.getState());
						te.addCount();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//				}
			}
		};
		Thread t1 = new MyThread(te1);
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
//				for (int i = 0; i < 5; i++) {
					try {
						te1.addCount1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//				}
			}
		});
//		t1.setDaemon(true);
		t1.start();
//		t1.join(200);
//		t1.sleep(7000);
		Thread.sleep(200);
		System.out.println("count=" + te1.count + t1.getState() );//最终打印的值并非10000，volatile对所有线程可见。
		t2.start();
//		t1.join(200);
		Thread.sleep(7000);
		System.out.println("count0=" + te1.count + t2.getState() );//最终打印的值并非10000，volatile对所有线程可见。
		System.out.println("count1=" + te1.count1 );//最终打印的值并非10000，volatile对所有线程可见。
	}
}
