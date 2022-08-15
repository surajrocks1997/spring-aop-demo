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
	
	@Before("execution(public * add*(com.demo.aopdemo.Account))")
	public void beforeAddAnyReturnWithParameter() {
		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on any RETURN TYPE with Account Parameter");
	}
	
	@Before("execution(public * add*(com.demo.aopdemo.Account, ..))")
	public void beforeAddAnyReturnWithMultipleParameter() {
		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on any RETURN TYPE with Account Parameter and Boolean Parameter");
	}
	
	@Before("execution(public * add*(..))")
	public void beforeAddAnyReturnAnyParameter() {
		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on any RETURN TYPE with ANY Parameter");
	}
	
	@Before("execution(public * com.demo.aopdemo.dao.*.*(..))")
	public void beforeAddAnyReturnAnyClassAnyParameterWithinPackage() {
		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on a any package with any class, any method and any parameter");
	}
}
