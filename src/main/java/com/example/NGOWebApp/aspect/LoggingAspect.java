package com.example.NGOWebApp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Log method execution for controllers
    @Around("execution(* com.example.NGOWebApp.controller.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        logger.info("Executed method: {} in {} ms", joinPoint.getSignature(), executionTime);
        return result;
    }

    // Log user authentication attempts
    @Before("execution(* com.example.NGOWebApp.controller.UserController.loginPage(..))")
    public void logLoginAttempt() {
        logger.info("User is trying to log in...");
    }

    // Log access to the Dashboard
    @Before("execution(* com.example.NGOWebApp.controller.AdminController.adminDashboard(..))")
    public void logDashboardAccess() {
        logger.info("User accessed the dashboard");
    }

    // Log access to the Donation page
    @Before("execution(* com.example.NGOWebApp.controller.DonationController.showDonationPage(..))")
    public void logDonationAccess() {
        logger.info("User accessed the donation page");
    }
}
