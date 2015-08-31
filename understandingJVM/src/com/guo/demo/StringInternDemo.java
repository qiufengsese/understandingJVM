package com.guo.demo;

public class StringInternDemo {
	public static void main(String[] args) {  
		String str1 = new StringBuilder("计算机").append("软件").toString();  
		System.out.println(str1.intern() == str1);  // true
		 
		String str2 = new StringBuilder("ja").append("va").toString();  
		System.out.println(str2.intern() == str2); //false
		// JDK1.7中的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用，
		// 因此intern()返回的引用和由StringBuilder创建的那个字符串实例是同一个。
		// 对str2比较返回false是因为“java”这个字符串在执行StringBuilder.toString()之前已经出现过，字符串常量池中已经有它的引用了，不符合“首次出现”的原则，
		// 而“计算机软件”这个字符串则是首次出现的，因此返回true。
	}
		 
}
