package com.guo.demo.chapter07;

public class ClinitBlockingDemo {
	static class DeadLoopClass {
		static {
			// 如果注释掉if的话，会编译失败，提示（Initializer does not complete normally
			if(true) {
				System.out.println(Thread.currentThread()+"init DeadLoopClass");
				while(true) {
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Runnable script = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread()+"start");
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread()+" run over");
			}
		};
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}
