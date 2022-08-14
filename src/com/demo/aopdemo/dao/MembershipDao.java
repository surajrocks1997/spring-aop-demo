package com.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public void addAccount() {
		System.out.println(getClass() + ": Adding Account");
	}
}
