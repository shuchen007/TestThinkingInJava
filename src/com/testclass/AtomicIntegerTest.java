package com.testclass;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author sunhao
 * @Description
 * @Date 13:26 2018/5/11
 * @Modified by
 */

	class MyThread implements Runnable {
//		    static  int i = 0;//有线程安全问题。
		static AtomicInteger ai=new AtomicInteger(0);


		public void run() {
			for (int m = 0; m < 10; m++) {
//				i++;
				int x = ai.incrementAndGet();//返回改变之后的值
				int x1 = ai.getAndIncrement();//返回改变之前的值
				System.out.println(x);
			}
		}
	};

	public class AtomicIntegerTest {
		public static void main(String[] args) throws InterruptedException {
			MyThread mt = new MyThread();

			Thread t1 = new Thread(mt);
			Thread t2 = new Thread(mt);
			t1.start();
			t2.start();
			Thread.sleep(500);
			System.out.println(MyThread.ai);
		}
	}
