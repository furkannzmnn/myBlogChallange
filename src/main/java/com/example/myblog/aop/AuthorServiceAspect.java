package com.example.myblog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorServiceAspect {

    private final Logger logger = LoggerFactory.getLogger(AuthorServiceAspect.class);

    @Before(value="execution(* com.example.myblog.service.AuthorService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.info("AUTHOR SERVICE ASPECT ||  Before AuthorService method got called");
    }

    @Before(value="execution(* com.example.myblog.service.AuthorService.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        logger.info("AUTHOR SERVICE ASPECT ||  After AuthorService method got called");
    }

    @Before(value="execution(* com.example.myblog.service.AuthorService.*(..))")
    public void  afterReturningAdvice   (JoinPoint joinPoint){
        logger.info("AUTHOR SERVICE ASPECT ||  AfterReturning  AuthorService method got called");
    }
}
