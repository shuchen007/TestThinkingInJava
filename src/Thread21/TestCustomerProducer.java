package Thread21;

/**
 * @Author sunhao
 * @Description
 * @Date 15:00 2018/4/13
 * @Modified by
 */

public class TestCustomerProducer {
	public static String value = "";
	private  Object lock;

	public TestCustomerProducer(Object lock) {
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!value.equals("")) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("set = " + value);
				this.value = value;
				lock.notify();
			}
		} catch (Exception e) {
		}
	}
	public void getValue(){
		try{
			synchronized (lock){
				if(value.equals("")){
					lock.wait();
				}
				String value = System.currentTimeMillis()+"_"+System.nanoTime();
				System.out.println("get = " + value);
				this.value = "";
				lock.notify();
			}
		}catch (Exception e){

		}

	}
	public static void main(String[] args) {
		Object lock = new Object();
		final TestCustomerProducer producer = new TestCustomerProducer(lock);
		final TestCustomerProducer customer = new TestCustomerProducer(lock);
//		final TestCustomerProducer td = new TestCustomerProducer();
		Thread t1 = new Thread(){
			@Override
			public void run() {
				while (true){
					producer.getValue();
				}
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				while (true){
					customer.setValue();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
