package Thread21;

import org.apache.log4j.helpers.ThreadLocalMap;

/**
 * @Author sunhao
 * @Description
 * @Date 9:28 2018/4/13
 * @Modified by
 */

public class TestInterrupt {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				while (true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("被中断！");
//						try {
//							Thread.sleep(2000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}

						break;
					}
					else {
						System.out.println("继续执行！");
						try {
							this.sleep(1100);
							System.out.println("a = " + this.getState());
//							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							System.out.println("do="+this.isInterrupted());
							this.interrupt();
						}

					}
				}
			}
		};
		t1.start();
		System.out.println("b1 = " + t1.getState());
		Thread.sleep(1000);
		System.out.println("b2 = " + t1.getState());
		t1.interrupt();
//		Thread.sleep(1000);
	}
}
