package com.demo.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private Logger myLogger = Logger.getLogger(getClass().getName());

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
//	@Before("forDaoPackage()")
//	public void beforeAddAnyReturnAnyClassAnyParameterWithinPackage() {
//		System.out.println(
//				"=======>>> Executing @Before Advice on ANY addAccount() on a any package with any class, any method and any parameter");
//	}
//
//	@Before("forDaoPackage() && !(getter() || setter())")
//	public void forDaoExcludingGetandSet() {
//		System.out.println("=======>>> Executing @Before Advice on forDaoExcludingGetandSet");
//	}

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

//	adding new advice for AfterReturning on the findAccount method
	@AfterReturning(pointcut = "execution(public * com.demo.aopdemo.dao.AccountDao.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("=======>>> Executing @AfterReturning Advice on method: " + method);

		System.out.println("=======>>> result is: " + result);

//		post process/modify the data before it is sent to program
//		converting the account name to upper case.
		convertAccountNamesToUpperCase(result);

		System.out.println("=======>>> result is: " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		for (Account account : result) {
			String theUpperName = account.getName().toUpperCase();
			account.setName(theUpperName);
		}
	}

	@AfterThrowing(pointcut = "execution(public * com.demo.aopdemo.dao.AccountDao.findAccounts(..))", throwing = "theException")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theException) {

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("=======>>> Executing @AfterThrowing Advice on method: " + method);

		System.out.println("=======>>> Exception is: " + theException);
	}

	@After("execution(public * com.demo.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().toShortString();
		System.out.println("=======>>> Executing @After (finally) Advice on method: " + method);
	}

	@Around("execution(public * com.demo.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("=======>>> Executing @After (finally) Advice on method: " + method);

		long begin = System.currentTimeMillis();

		Object result = theProceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		long duration = end - begin;
		myLogger.info("========>>> Duration " + duration / 1000.0 + " seconds");

		return result;
	}
}
