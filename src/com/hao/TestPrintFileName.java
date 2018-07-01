package com.hao;

import java.io.File;

/**
 * @Author sunhao
 * @Description
 * @Date 14:26 2018/6/13
 * @Modified by
 */

public class TestPrintFileName {
	private static void printLev(File dir,int level){
		File[] subFiles = dir.listFiles();
		for (File subFile : subFiles) {
			for (int i = 0; i < level; i++) {
				System.out.print("\t");
			}
			System.out.println(subFile);
			if (subFile.isDirectory()) {
				printLev(subFile,level++);
			}
		}
	}
	
	public static void main(String[] args) {
		File dir = new File("F:/行政资料12");
		printLev(dir,0);
	}
}
