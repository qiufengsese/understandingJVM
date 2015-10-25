package com.guo.demo.chapter07;

public class FieldResolution {
	interface Interface0 {
		int A = 0;
	}
	interface Interface1 extends Interface0 {
		int A = 1;
	}
	interface Interface2 {
		int A = 2;
	}
	static class Parent implements Interface1 {
		public static int A = 3;
	}
	static class Sub extends Parent implements Interface2 {
		// 如果把变量A注释掉的话，会编译报错(The field Sub.A is ambiguous)，因为父类以及接口中都有A这个变量，不知道选择哪个了。
		public static int A = 4;
	}
	
	public static void main(String[] args) {
		System.out.println(Sub.A);
	}
	
}
