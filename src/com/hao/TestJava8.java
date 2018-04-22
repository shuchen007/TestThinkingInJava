package com.hao;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * @Author sunhao
 * @Description
 * @Date 16:25 2018/4/20
 * @Modified by
 */

public class TestJava8 {
	public static void main(String[] args) {
		new ConcurrentHashMap<>();
		List<String> list = new Vector<>();
		list.add("a");
		list.add("b");
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		list.forEach(s ->{
			System.out.println(s);
		}
		);

		final Clock clock = Clock.systemUTC();
		System.out.println( clock.instant() );
		System.out.println( clock.millis());

		// Get the local date and local time
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now( clock );
		System.out.println( date );
		System.out.println( dateFromClock );

		// Get the local date and local time
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now( clock );
		System.out.println( time );
		System.out.println( timeFromClock );

		TestJava8 tester = new TestJava8();
		// 类型声明
		MathOperation addition = (int a, int b) -> a + b;
		// 不用类型声明
		MathOperation subtraction = (a, b) -> a - b;
		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> { return a * b; };
		// 没有大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));
	}
	interface MathOperation {
		int operation(int a, int b);
	}
	private int operate(int a, int b, MathOperation mathOperation){
		return mathOperation.operation(a, b);
	}
}
