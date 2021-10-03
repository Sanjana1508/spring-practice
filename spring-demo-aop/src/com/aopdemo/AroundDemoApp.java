package com.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import com.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theTrafficService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		//System.out.println("Main Program");
		myLogger.info("Main Program");
		
		String data = theTrafficService.getFortune();
		myLogger.info("Fortune : "+data);
		myLogger.info("Finished");
		
		//System.out.println("Fortune : "+data);
		//System.out.println("Finished");
		context.close();
	}

}
