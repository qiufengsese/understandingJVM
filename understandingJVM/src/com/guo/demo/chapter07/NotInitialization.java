package com.guo.demo.chapter07;

class SuperClass {
	static {
		System.out.println("SuperClass init");
	}
	public static int value = 123;
}

class SubClass extends SuperClass{
	static {
		System.out.println("SubClass init");
	}
}

public class NotInitialization {
	public static void main(String[] args) {
		// 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，只会出发父类的初始化而不会出发子类的初始化
		 System.out.println(SubClass.value);
		
		// 通过数组定义来引用类，不会触发此类的初始化
		SuperClass[] sca = new SuperClass[10];
		
		// 引用的是某类的常量池，属于是编译期的常量，所以没有初始化；通过反编译发现，已经变成常量字符串。
		System.out.println(ConstClass.HELLOWORLD);
	}
}

class ConstClass {
	static {
		System.out.println("ConstClass init!");
	}
	public static final String HELLOWORLD = "hello world";
}