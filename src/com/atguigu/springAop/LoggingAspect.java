package com.atguigu.springAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//这是一个切面11111111
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.atguigu.springAop.ArithmeticCalculatorImpl.*(int,int))")
    public void BeforeMethod(JoinPoint joinPoint){
        String MethodName = joinPoint.getSignature().getName();
        List<Object> l = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ MethodName +" begins with " + l);
    }

    //无论发生异常与否  都执行
    @After("execution(* com.atguigu.springAop.ArithmeticCalculatorImpl.*(..))")
    public void AfterMethod(JoinPoint joinPoint){
        String MethodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ MethodName +" ends ");

    }

    @AfterReturning(value="execution(public int com.atguigu.springAop.ArithmeticCalculatorImpl.*(..))",
            returning="result")
    public void AfterReturiingMethod(JoinPoint joinPoint, Object result){
        String MethodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ MethodName +" ends with " + result);
    }

    @AfterThrowing(value="execution(public int com.atguigu.springAop.ArithmeticCalculatorImpl.*(..))",
            throwing="e")
    public void AfterThrowingMethod(JoinPoint joinPoint,Exception e){
        String MethodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ MethodName +" occurs Exception " + e);
    }

    @Around("execution(public int com.atguigu.springAop.ArithmeticCalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        String MethodName = proceedingJoinPoint.getSignature().getName();
        Object result = null;
        List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());
        try {
            //前置通知
            System.out.println("The method "+ MethodName +" begins with " + args);
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The method "+ MethodName +" ends with "+result);
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("The method "+ MethodName +" occurs Exception " + throwable);
          //  throwable.printStackTrace();
        }
        //后置通知
        System.out.println("The method "+ MethodName +" ends");
        return result;
    }








}
