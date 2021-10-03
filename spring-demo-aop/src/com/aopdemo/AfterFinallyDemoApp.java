package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> myAccounts = null;
		try {
			boolean flag=false;
			myAccounts = theAccountDAO.findAccounts(flag);
		}
		catch(Exception exc) {
			System.out.println("\nMain program caught exception : "+exc);
		}
		
		System.out.println("\nMain Program :");
		
			System.out.println(myAccounts);
		
		
		context.close();
	}

}
