package com.guo.demo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class JavaMethodAreaOOM {
	public static void main(String[] args) {
		try {
			while(true) {
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOMObject.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					public Object intercept(Object obj,Method method,Object[] args,MethodProxy proxy) throws Throwable {
						return proxy.invokeSuper(obj, args);
					}
				});
				enhancer.create();
			}
		}catch(Exception e) {
			System.out.println(1111);
			e.printStackTrace();
		}
	}
	static class OOMObject{
		
	}
}
