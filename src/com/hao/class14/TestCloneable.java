package com.hao.class14;

import com.hao.collection11.Apple;

/**
 * Created by sunhao on 2018/3/29.
 *
 * @描述
 */
public class TestCloneable {
	public static void main(String[] args) throws CloneNotSupportedException {
		Stutend stutend1 = new TestCloneable().new Stutend();
		stutend1.setAge(34);
		stutend1.setName("fd");
		System.out.println(stutend1.getAge());
		Stutend stutend2 = (Stutend) stutend1.clone();
		System.out.println((stutend1==stutend2)+"||"+(stutend1.getClass()==stutend2.getClass())+(stutend1.equals(stutend2)));
		System.out.println(stutend2.getAge());
		stutend2.setAge(43);
		System.out.println(stutend2.getAge());
		System.out.println(stutend1.getAge());
	}
	class Stutend implements Cloneable{
		private String name;
		private int age;
		@Override
		public Object clone() throws CloneNotSupportedException
		{
			return super.clone();
		}
		protected native String ds() throws Exception;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
