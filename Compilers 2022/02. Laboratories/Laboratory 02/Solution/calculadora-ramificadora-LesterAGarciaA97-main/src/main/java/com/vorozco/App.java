package com.vorozco;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(2, 2));
        System.out.println(calculator.subtract(10, 2));
        System.out.println(calculator.multiply(10, 10));
        System.out.println(calculator.divide(10, 10));
    }
}

