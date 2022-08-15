package com.demo.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.aopdemo.Account;

@Aspect
@Component
@Order(1)
//order can have any number from negative to positive. priority start from most negative to most positive
public class MyDemoLoggingAspect {

//	@Before("execution(public void com.demo.aopdemo.dao.AccountDao.addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("=======>>> Executing @Before Advice on addAccount()");
//	}
//	
//	@Before("execution(public void add*())")
//	public void beforeAddAny() {
//		System.out.println("=======>>> Executing @Before Advice on ANY addAccount()");
//	}
//	
//	@Before("execution(public * add*())")
//	public void beforeAddAnyReturn() {
//		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on any RETURN TYPE");
//	}
//	
//	@Before("execution(public * add*(com.demo.aopdemo.Account))")
//	public void beforeAddAnyReturnWithParameter() {
//		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on any RETURN TYPE with Account Parameter");
//	}
//	
//	@Before("execution(public * add*(com.demo.aopdemo.Account, ..))")
//	public void beforeAddAnyReturnWithMultipleParameter() {
//		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on any RETURN TYPE with Account Parameter and Boolean Parameter");
//	}
//	
//	@Before("execution(public * add*(..))")
//	public void beforeAddAnyReturnAnyParameter() {
//		System.out.println("=======>>> Executing @Before Advice on ANY addAccount() on any RETURN TYPE with ANY Parameter");
//	}

	@Pointcut("execution(public * com.demo.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution(public * com.demo.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(public * com.demo.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

//	point cut declaration reuse from above
	@Before("forDaoPackage()")
	public void beforeAddAnyReturnAnyClassAnyParameterWithinPackage() {
		System.out.println(
				"=======>>> Executing @Before Advice on ANY addAccount() on a any package with any class, any method and any parameter");
	}

	@Before("forDaoPackage() && !(getter() || setter())")
	public void forDaoExcludingGetandSet() {
		System.out.println("=======>>> Executing @Before Advice on forDaoExcludingGetandSet");
	}

//	Join points
	@Before("execution(public * add*(..))")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("=======>>> Executing @Before Advice for Add Account method");

//		display method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("method signature: " + methodSignature);

//		display method arguments
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("AccountName: " + theAccount.getName());
				System.out.println("AccountLevel: " + theAccount.getLevel());
			}
		}
	}
}
