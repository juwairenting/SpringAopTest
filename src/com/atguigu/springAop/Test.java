package com.atguigu.springAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-aop.xml");
        ArithmeticCalculator ac =(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        int result = ac.add(3,1);
        System.out.println(result);

        result = ac.dev(3,0);
        System.out.println(result);
    }
}
