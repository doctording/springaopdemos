package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * log代理类
 */
public class LogInterceptorProxyHandler implements InvocationHandler {

	// 被代理对象
	private Object target;
	
	public void beforeMethod(){
		System.out.println(target.getClass().getSimpleName() + " log start...");
	}

	@Override
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {

		// 被代理对象执行前执行
		beforeMethod();
		
		m.invoke(target, args);
		
		return null;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
