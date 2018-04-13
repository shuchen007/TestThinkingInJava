package Thread21;

import java.util.Collections;

/**
 * @Author sunhao
 * @Description
 * @Date 16:49 2018/4/11
 * @Modified by
 */

public class TestWait {
	static int a;
	public synchronized void doTest(String xd) throws InterruptedException {
		for (int i = 0; i < 8; i++) {
			a++;
			Thread.sleep(1000);
			if (3==a){
				try{
					this.wait();
				}catch (Exception e){
					System.out.println("do");
				}
			}
		}
	}
	public synchronized void doTest2(String xd) throws InterruptedException {
		for (int i = 0; i < 8; i++) {
			a++;
			Thread.sleep(1000);
			if (5==a){
				this.wait();
				System.out.println("begin1=" + a);
			}
			System.out.println(a);
		}
	}
	public synchronized void doTest3(String xd) throws InterruptedException {
//		System.out.println("start");
		this.notifyAll();
		Thread.sleep(4000);
	}
	public static void main(String[] args) throws InterruptedException {
		final TestWait testWait = new TestWait();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					testWait.doTest("dfdf");
					System.out.println("1=" + this.getState());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					testWait.doTest2("fdsf");
					System.out.println("2=" + this.getState());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t3 = new Thread(){
			@Override
			public void run() {
				super.run();
				try {
					testWait.doTest3("fdsf");
					System.out.println("3=" + this.getState());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		Thread.sleep(500);
		System.out.println(t1.getState());
//		t1.interrupt();
//		t2.start();
		Thread.sleep(4000);
		System.out.println("a= "+t1.getState());
		t3.start();
		Thread.sleep(2000);
		System.out.println("a= "+t1.getState());
//		System.out.println(t1.isInterrupted());
//		t1.interrupt();
//		System.out.println(t1.isInterrupted());
		Thread.sleep(2200);
		System.out.println("a= "+t1.getState());
		String x = "a";
		System.out.println(x.hashCode());
	}
}
