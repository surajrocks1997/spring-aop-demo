package com.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Before("execution(public void com.demo.aopdemo.dao.AccountDao.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("=======>>> Executing @Before Advice on addAccount()");
	}
	
	@Before("execution(public void add*())")
	public void beforeAddAny() {
		System.out.println("=======>>> Executing @Before Advice on ANY addAccount()");
	}
	
	@Before("execution(public * add*())")
	public void beforeAddAnyReturn() {
		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on any RETURN TYPE");
	}
}
