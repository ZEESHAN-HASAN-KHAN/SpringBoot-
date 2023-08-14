package com.niit.userauthenticationservice.aspects;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    private Logger logger;
    private LogAspect(){
        System.out.println("Inside constructor or logger aspect");
    }

    @Pointcut("execution (* com.niit.userauthenticationservice.controller.*.*(..))")
    public void controllerMethods(){
        System.out.println("Inside controller methods........");
    }
    @Before("controllerMethods()")
    public void beforeAdvice(org.aspectj.lang.JoinPoint joinPoint) {
        /* compiled code */
        System.out.println("Running before Advice.......");
    }

    @After("controllerMethods()")
    public void afterAdvice(org.aspectj.lang.JoinPoint joinPoint) {
        /* compiled code */
        System.out.println("Running after Advice.........");
    }

    @AfterReturning(value = "controllerMethods()", returning = "result")
    public void afterAdvice(org.aspectj.lang.JoinPoint joinPoint, Object result) {
        /* compiled code */
        System.out.println("Returning result after advice......");
    }
    @AfterThrowing(value = "controllerMethods()", throwing = "error")
    public void afterAdvice(org.aspectj.lang.JoinPoint joinPoint, Throwable error)
    {
        /* compiled code */
        System.out.println("Throwing error if after advice encounters some error......");
    }
}
