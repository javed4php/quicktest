package com.ca.digital.aop;

import java.sql.Connection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrailModeAspect{
	
	@AfterReturning()
	public void insertSuccessAuditToTrialEvent(){
		
	}
	@AfterThrowing
	public void insertAuditToTrialEvent(){
		
	}
	@Around("onCreate")
	public void handleConnection(ProceedingJoinPoint joinpoint) {
	//do connection creation
	try {

			//how to pass the connection object to the pointcut implementation?
	                Object result = joinpoint.proceed();
	            } catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
	               
	            }
	        
	        
	    
	}
	@Pointcut("execution(* com.ca.digital.service..*.execute(..))")
    public void onCreate() {}
}
