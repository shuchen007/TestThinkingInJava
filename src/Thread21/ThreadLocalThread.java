package Thread21;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author sunhao
 * @Description
 * @Date 11:10 2018/4/13
 * @Modified by
 */

public class ThreadLocalThread extends Thread{
	private  AtomicInteger ai = new AtomicInteger();
	public ThreadLocalThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		try
		{
			for (int i = 0; i < 3; i++)
			{
				Tools.t1.set(ai.addAndGet(2) + "");
				System.out.println(this.getName() + " get value--->" + Tools.t1.get());
				Thread.sleep(200);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThreadLocalThread a = new ThreadLocalThread("ThreadA");
		ThreadLocalThread b = new ThreadLocalThread("ThreadB");
		ThreadLocalThread c = new ThreadLocalThread("ThreadC");
		a.start();
		b.start();
		c.start();
		for (int i = 0; i < 5; i++) {
			System.out.println(new ThreadLocalThread("fd").ai.addAndGet(1));
		}

	}
}
