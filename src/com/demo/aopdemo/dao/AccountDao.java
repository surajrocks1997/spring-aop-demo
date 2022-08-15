package com.demo.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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

	public void setAccount() {
		System.out.println(getClass() + ": Setting Account");
	}

	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		Account temp1 = new Account("Luca", "Gold");
		Account temp2 = new Account("Mark", "Platinum");

		accounts.add(temp1);
		accounts.add(temp2);
		return accounts;
	}
}
