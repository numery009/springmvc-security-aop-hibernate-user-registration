package com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations

	// pointcut expretion for controller
	@Pointcut("execution( * com.springdemo.controller.*.*(..))")
	private void forControllerPackage() {

	}

	// pointcut expretion for service
	@Pointcut("execution( * com.springdemo.service.*.*(..))")
	private void forServicePackage() {

	}

	// pointcut expretion for dao
	@Pointcut("execution( * com.springdemo.dao.*.*(..))")
	private void forDAOPackage() {

	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {

	}

	// add @Before advice
	@Before("forAppFlow()")
	private void before(JoinPoint theJointPoint) {

		// dispaly the methid we are calling
		String theMethod = theJointPoint.getSignature().toShortString();
		myLogger.info("=====>>>> in @Before: calling method: " + theMethod);

		// display the arguments to the method

		// get the arguments
		Object[] args = theJointPoint.getArgs();

		// loop thru and display args
		for (Object arg : args) {
			myLogger.info("====>>> argument " + arg);
		}

	}

	// add @AfterReturning advice

	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	private void afterReturning(JoinPoint theJointPoint, Object theResult) {

		// display method we are returning from
		String theMethod = theJointPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @AfterReturning: calling method:"
				+ theMethod);

		// display data returned
		myLogger.info("====>>> result :" + theResult);

	}
}
