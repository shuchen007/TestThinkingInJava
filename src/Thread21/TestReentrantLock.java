package Thread21;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author sunhao
 * @Description
 * @Date 12:46 2018/4/13
 * @Modified by
 */

public class TestReentrantLock extends ReentrantReadWriteLock {
	public void read()
	{
		try
		{
			readLock().lock();
			System.out.println(Thread.currentThread().getName() + "获得了读锁, 时间为" +
					System.currentTimeMillis());
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			readLock().unlock();
		}
	}

	public void write()
	{
		try
		{
			writeLock().lock();
			System.out.println(Thread.currentThread().getName() + "获得了写锁, 时间为" +
					System.currentTimeMillis());
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			writeLock().unlock();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		final TestReentrantLock td = new TestReentrantLock();
		Runnable readRunnable = new Runnable()
		{
			public void run()
			{
				td.write();
			}
		};
		Runnable readRunnable1 = new Runnable()
		{
			public void run()
			{
				td.read();
			}
		};
		Thread t0 = new Thread(readRunnable);
		Thread t1 = new Thread(readRunnable1);
		t1.start();
//		t1.join(100);
		t0.start();
	}
}
