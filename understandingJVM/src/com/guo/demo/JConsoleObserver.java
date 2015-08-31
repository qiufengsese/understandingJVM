package com.guo.demo;

import java.util.ArrayList;
import java.util.List;

public class JConsoleObserver {
	static class OOMObject {
		public byte[] placeholder = new byte[64*1024];
	}
	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list = new ArrayList<OOMObject>();
		for(int i =0;i<num;i++) {
			Thread.sleep(20);
			list.add(new OOMObject());
		}
		System.gc();
		Thread.sleep(2000);
	}
	public static void main(String[] args) throws Exception {
		fillHeap(1000);
		
	}
}
