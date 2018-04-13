package Thread21;

/**
 * @Author sunhao
 * @Description
 * @Date 16:16 2018/4/13
 * @Modified by
 */

public class TestThreadGroup {
	static Runnable t = new Runnable() {
		@Override
		public void run() {
			try
			{
				while (!Thread.currentThread().isInterrupted())
				{
					System.out.println("ThreadName = " + Thread.currentThread().getName());
					Thread.sleep(3000);
				}
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	};
	public static void main(String[] args) {
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		ThreadGroup tg = new ThreadGroup("新建线程组1");
		Thread t10 = new Thread(tg, t1);
		Thread t20 = new Thread(tg, t2);
		t10.start();
		t20.start();
		System.out.println("活动的线程数为：" + tg.activeCount());
		System.out.println("线程组的名称为：" + tg.getName());
	}
}
