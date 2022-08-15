package com.demo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.dao.AccountDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);

		List<Account> theAccounts = theAccountDao.findAccounts();
		
		System.out.println("From AfterReturningDemoApp");
		
		System.out.println(theAccounts);
		
		context.close();
	}
}
