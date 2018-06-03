package com.hao.designPattern.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author sunhao
 * @Description 动态代理，利用反射机制来代理类，解决多类代理问题，代理类在运行期间反射生成。被代理类的改变在编译期间不影响代理类的产生。
 * @Date 9:42 2018/5/10
 * @Modified by
 */

public class DynamicProxy {
	interface IDinner {
		void eat();
	}
	final class Dinner implements IDinner{
		@Override
		public void eat() {
			System.out.println("eat");
		}
	}
	class DinnerProxy{
		private IDinner iDinner;
		public DinnerProxy(IDinner iDinner) {
			this.iDinner = iDinner;
		}
		public IDinner getProxyInstance(){
			class x implements InvocationHandler{
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("wash");
					Object object = method.invoke(iDinner,args);
					System.out.println("wash!!");
					return null;
				}
			}
			InvocationHandler invocationHandler = new x();
			DynamicProxy.IDinner proxy = (IDinner) Proxy.newProxyInstance(
					iDinner.getClass().getClassLoader(), iDinner.getClass().getInterfaces(),invocationHandler);
			return proxy;
		}
	}
	public static void main(String[] args) {
		new DynamicProxy().new DinnerProxy(new DynamicProxy().new Dinner()).getProxyInstance().eat();
	}
}
