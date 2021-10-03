package com.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;
import com.aopdemo.AroundDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private  Logger myLogger = Logger.getLogger(getClass().getName());

	
	@Around("execution(* com.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\nExecuting @Around advice on method : "+method);
		
		long begin = System.currentTimeMillis();
		
		Object data =null;
		
		try {
			
			data = theProceedingJoinPoint.proceed();
		} 
		catch (Exception e) {
			
			myLogger.warning(e.getMessage());
			
			//data="Handled the exception in @Around";
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end-begin;
		myLogger.info("Duration : "+(duration/1000.0));
		
		return data;
	}
	
	
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\nExecuting @After (finally) advice on method : "+method);
		
	}
	
	@AfterThrowing(pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\nExecuting @AfterThrowing advice on method : "+method);
		
		myLogger.info("\nThe Exception is : "+theExc);
		
		
	}
	
	@AfterReturning(pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\nExecuting @AfterReturning advice on method : "+method);
		
		myLogger.info("\nresult : "+result);
		
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n uppercase result : "+result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account tempAccount : result) {
			
			String upper = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(upper);
		}
		
	}


	//@Before("execution(*  com.aopdemo.dao.*.*(..)):)

	@Before("com.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\nExecuting @Before advice beforeAddAccountAdvice");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: "+methodSig);
		
		Object args[] = theJoinPoint.getArgs();
		
		for(Object tempArg : args) {
			
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				
				Account theAccount = (Account) tempArg;
				
				myLogger.info("Account name : "+theAccount.getName() );

				myLogger.info("Account level : "+theAccount.getLevel() );
				
			}
		}
	}
	
	
	
	
}