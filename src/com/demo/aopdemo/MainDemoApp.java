package com.demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aopdemo.dao.AccountDao;
import com.demo.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
//		theAccountDao.addAccount();

//		theAccountDao.addAccount(new Account());
		theAccountDao.addAccount(new Account(), true);
		theAccountDao.setAccount();
		
		MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
		membershipDao.addAccount();
		

		context.close();
	}
}
