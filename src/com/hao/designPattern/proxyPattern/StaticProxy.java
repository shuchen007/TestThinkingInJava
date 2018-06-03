package com.hao.designPattern.proxyPattern;

/**
 * @Author sunhao
 * @Description 静态代理模式，首先生成对应的代理类，编译期间就有对应的二进制文件
 * @Date 9:21 2018/5/10
 * @Modified by
 */

public class StaticProxy {
	 interface IDinner {
		void eat();
	}
	final class Dinner implements IDinner{
		@Override
		public void eat() {
			System.out.println("eat");
		}
	}
	class DinnerProxy implements IDinner{
		private IDinner iDinner;
		public DinnerProxy(IDinner iDinner) {
			this.iDinner = iDinner;
		}
		@Override
		public void eat() {
			System.out.println("wash");
			iDinner.eat();
			System.out.println("wash too");
		}
	}
	public static void main(String[] args) {
		StaticProxy.Dinner x = new StaticProxy().new Dinner();
		IDinner iDinner = new StaticProxy().new DinnerProxy(x);
		iDinner.eat();
	}
}
