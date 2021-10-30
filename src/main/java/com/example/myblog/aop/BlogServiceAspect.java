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
public class BlogServiceAspect {
    private Logger logger = LoggerFactory.getLogger(BlogServiceAspect.class);

    @Before(value="execution(* com.example.myblog.service.BlogService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
       logger.info("BLOG SERVICE ASPECT ||  Before BlogService method got called");
    }

    @After(value="execution(* com.example.myblog.service.BlogService.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        logger.info("BLOG SERVICE ASPECT ||  After BlogService method got called");
    }

    @AfterReturning(value="execution(* com.example.myblog.service.BlogService.*(..))")
    public void  afterReturningAdvice   (JoinPoint joinPoint){
        logger.info("BLOG SERVICE ASPECT ||  AfterReturning  BlogService method got called");
    }


}
