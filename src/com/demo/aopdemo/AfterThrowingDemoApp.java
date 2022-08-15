package com.demo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.dao.AccountDao;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);

		List<Account> theAccounts = null;

		try {
//			add a bool flag to simulate an exception
			boolean tripWire = true;
			theAccounts = theAccountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Main Program: caught exception: " + e);
		}

		System.out.println("From AfterThrowingDemoApp");

		System.out.println(theAccounts);

		context.close();
	}
}
