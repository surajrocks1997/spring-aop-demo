package com.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.demo.aopdemo.Account;

@Component
public class AccountDao {

	public void addAccount() {
		System.out.println(getClass() + ": Adding Account");
	}

	public void addAccount(Account account) {
		System.out.println(getClass() + ": Adding Account with Account Parameter");
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": Adding Account with Account and Bool Parameter");
	}
}
