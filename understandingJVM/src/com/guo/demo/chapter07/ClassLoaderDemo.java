package com.guo.demo.chapter07;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderDemo {
	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					// 加载自己同一路经下的class文件
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name,b,0,b.length);
				}catch(IOException ioe) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myLoader.loadClass("com.guo.demo.chapter07.ClassLoaderDemo").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj.getClass().getClassLoader());
		System.out.println(obj instanceof com.guo.demo.chapter07.ClassLoaderDemo);
		Object obj2 = new ClassLoaderDemo();
		System.out.println(obj2.getClass());
		System.out.println(obj2.getClass().getClassLoader());
		System.out.println(obj2 instanceof com.guo.demo.chapter07.ClassLoaderDemo);
		
	}
}
