package com.bjsxt.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {

	@Before("execution(public * com.bjsxt.service..*.add(..))")
	public void before() {
		System.out.println("method before...");
	}

	@After("execution(public * com.bjsxt.service..*.destroy(..))")
	public void after() {
		System.out.println("method after...");
	}

}
