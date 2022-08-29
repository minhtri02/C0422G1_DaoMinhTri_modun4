package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

    @Before("execution(* com.example.controller.BookController.*(..))")
    public void before(JoinPoint joinPoint){
        System.err.println("method đang chạy "+ joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.controller.BookController.*(..))")
    public void processing(JoinPoint joinPoint){
        System.err.println("Method " + joinPoint.getSignature().getName() + " Đã chạy xong");
    }

    @AfterThrowing(pointcut = "execution(* com.example.controller.BookController.*(..))")
    public void errors(JoinPoint joinPoint){
        System.err.println("Method " + joinPoint.getSignature().getName() + " đã đc ném ra ngoài");
    }
}
