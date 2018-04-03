package com.atguigu.springAop;

import org.springframework.stereotype.Repository;

@Repository("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    int result;
    @Override
    public int add(int i, int j) {
        result = i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        result = i-j;
        return result;
    }

    @Override
    public int mul(int i, int j) {

        result = i*j;
        return result;
    }

    @Override
    public int dev(int i, int j) {

        result = i/j;
        return result;
    }
}
