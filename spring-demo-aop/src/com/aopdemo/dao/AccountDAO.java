package com.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean flag){
		
		if(flag)
			throw new RuntimeException("simulating an exception");
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("Madhu","Platinum");
		Account temp2 = new Account("Luca","Gold");
		Account temp3 = new Account("John","Silver");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}

	public void addAccount(Account account,boolean vipFlag) {
		
		System.out.println(getClass()+" adding account");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass()+" doWork()");
		
		return false;
	}

	public String getName() {
		System.out.println(getClass()+" getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+" getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
}
