package com.hao.initialization05;

/**
 * Created by Administrator on 2017/8/27.
 */
public class TestStaticSort {
        static {
            System.out.println("父类--静态代码块");
        }

        public TestStaticSort() {
            System.out.println("父类--构造函数");
        }

        {
            System.out.println("父类--非静态代码块");
        }
     public static void main(String[] args) {
         ExB exB = new ExB();
         System.out.println(exB.x1());
         System.out.println(exB.b);
         System.out.println(ExB.x2());
         System.out.println(ExB.a);
     }
}
//父类--静态代码块
//        子类--静态代码块
//        父类--非静态代码块
//        父类--构造函数
//        子类--非静态代码块
//        子类--构造函数
//        普通静态方法
//        null
//        1

//          构造方法是只有你在new对象的时候才会执行,静态语句块和静态方法在类加载到内存的时候就已经执行了
//        ,另外,静态语句块只能给静态变量赋值,里面不能出现方法,同样,静态方法里面也不能出现静态语句块
//        追问
//        调用静态方法之前是不是先执行了静态语句块呢
//        追答
//        对,先是静态语句块执行,然后静态方法加载到内存.
//        静态语句块你不管它它自动会执行,而静态方法它一直存在于内存中,只有你用类名点方法名的时候才会执行