package com.demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.dao.AccountDao;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
		
		theAccountDao.addAccount();
		
		context.close();
	}
}
