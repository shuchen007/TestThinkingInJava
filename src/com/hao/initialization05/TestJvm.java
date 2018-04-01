package com.hao.initialization05;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 */
public class TestJvm extends Thread {
    int i = 1;

    static {
        System.out.println("--类加载");
    }

    @Override
    public synchronized void run() {
        do2();
    }

    //调用方法实现栈溢出。
    void do2() {
        do2();
    }

    ;

    public synchronized void do1() {
        System.out.println("do2" + (i++));
    }

    public TestJvm() {
        System.out.println("--构造函数");
    }

    public static void main(String[] args) {
//        new Thread(new TestJvm());
//        for (int i = 0; i < 5; i++) {
//            TestJvm t1 = new TestJvm();
//            t1.start();
//        }
        TestRunnable tx = new TestRunnable();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(tx);
            t.start();
        }
        System.gc();
        //测试常量池溢出
//        int i = 0;
//        List<String> list = new ArrayList<String>();
//        while (true){
//            list.add(String.valueOf(i++).intern());
//        }
    }
}

class TestRunnable implements Runnable {
    int i = 1;

    @Override
    public void run() {
        System.out.println("run" + (i++));
    }
}
