package com.vorozco;

import java.math.BigInteger;

public class App 
{
    public static void main( String[] args )
    {
        Long maxNumber = 29L;
        System.out.print("Fibonacci Series of "+maxNumber+" numbers: ");

        var fibonacci = new FibonacciCreator();
        for(long i = 0; i < maxNumber; i++){
            System.out.println( (i) + " " + fibonacci.getFibonacciNumber(BigInteger.valueOf(i)) +" ");
        }

        System.out.println("Finish");
    }

}
