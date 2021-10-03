package com.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\nExecuting @Before advice beforeAddAccountAdvice");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+methodSig);
		
		Object args[] = theJoinPoint.getArgs();
		
		for(Object tempArg : args) {
			
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name : "+theAccount.getName() );

				System.out.println("Account level : "+theAccount.getLevel() );
				
			}
		}
	}
	
	
	
	
}