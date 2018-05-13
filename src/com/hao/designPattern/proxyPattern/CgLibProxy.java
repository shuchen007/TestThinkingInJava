package com.hao.designPattern.proxyPattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author sunhao
 * @Description cglib代理：被代理的对象没有接口，且不能为final类型。代理后在内部实现继承被代理的对象。
 * @Date 10:18 2018/5/10
 * @Modified by
 */

public class CgLibProxy {
	class Dinner{
		public void eat() {
			System.out.println("eat");
		}
	}
	class ProxyFactory implements MethodInterceptor {
		private Dinner dinner;
		public ProxyFactory(Dinner dinner) {
			this.dinner = dinner;
		}
		// 给目标对象创建一个代理对象
		public Object getProxyInstance(){
			//1.工具类
			Enhancer en = new Enhancer();
			//2.设置父类
			en.setSuperclass(dinner.getClass());
			//3.设置回调函数
			en.setCallback(this);
			//4.创建子类(代理对象)
			return en.create();
		}
		@Override
		public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
			System.out.println("wash");
			Object object = method.invoke(dinner,objects);
			System.out.println("wash!!");
			return object;
		}
	}
	public static void main(String[] args) {
		((Dinner)new CgLibProxy().new ProxyFactory(new CgLibProxy().new Dinner()).getProxyInstance()).eat();
	}
}
