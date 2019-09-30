package com.qfedu.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class AspectDemo2  {

    public void openTx() {

        System.out.println("openTx");
    }

    public void commitTx() {

        System.out.println("commitTx");
    }




    @Before("execution(* com.qfedu.service..*ServiceImpl.*(..))")
    public void before(){
        System.out.println("这是前置通知代码");
    }

    @AfterReturning("execution(* com.qfedu.service..*ServiceImpl.*(..))")
    public void after01(){
        System.out.println("这是后置通知代码（出现异常不调用）");
    }

    @After("execution(* com.qfedu.service..*ServiceImpl.*(..))")
    public void after02(){
        System.out.println("这是后置通知代码（都调用）");
    }

    @AfterThrowing("execution(* com.qfedu.service..*ServiceImpl.*(..))")
    public void afterException(){
        System.out.println("妈呀，出异常了，怎么办？");
    }

    @Around("execution(* com.qfedu.service..*ServiceImpl.*(..))")
    public Object  around(ProceedingJoinPoint pip) throws Throwable{
        System.out.println("这是环绕通知前");
        Object obj=pip.proceed();
        System.out.println("这是环绕通知后");
        return obj;
    }


}
