package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> myAccounts = theAccountDAO.findAccounts(false);
		
		System.out.println("\nMain Program :");
		
			System.out.println(myAccounts);
		
		/*MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		theAccountDAO.addAccount(new Account(),true);
		theAccountDAO.doWork();
		
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();*/
		
		context.close();
	}

}
