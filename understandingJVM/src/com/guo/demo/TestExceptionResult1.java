package com.guo.demo;

public final class TestExceptionResult1 {
	public static final int i = 1;
//	public static void main(String[] args) {
//		System.out.println(test());
//	}
	public static int test() {
		int x = 1;
		try {
			x = 2;
			return x;
		}catch(Exception e) {
			x = 3;
			return x;
		}finally {
			x =4 ;
			return x;
		}
	}
}
