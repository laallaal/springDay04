package com.qfedu.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectDemo {

    public void openTx() {

        System.out.println("openTx");
    }

    public void commitTx() {

        System.out.println("commitTx");
    }


    // 前置通知
    public void before(){
        System.out.println("这是前置通知代码");
    }

    // 后置通知
    public void after01(){
        System.out.println("这是后置通知代码（出现异常不调用）");
    }

    // 后置通知
    public void after02(){
        System.out.println("这是后置通知代码（都调用）");
    }

    //异常通知
    public void afterException(){
        System.out.println("妈呀，出异常了，怎么办？");
    }

    //环绕通知
    public Object  around(ProceedingJoinPoint pip) throws Throwable{
        System.out.println("这是环绕通知前");
        Object obj=pip.proceed();
        System.out.println("这是环绕通知后");
        return obj;
    }


}
