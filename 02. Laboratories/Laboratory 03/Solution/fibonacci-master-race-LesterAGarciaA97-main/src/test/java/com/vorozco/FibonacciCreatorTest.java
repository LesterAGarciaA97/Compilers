package com.vorozco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciCreatorTest {

    FibonacciCreator fibo;
    @BeforeEach
    public void init(){
        fibo = new FibonacciCreator();
    }

    @Test
    @Timeout(value = 1)
    public void simpleFibonacci(){
        assertEquals(BigInteger.valueOf(8), fibo.getFibonacciNumber(BigInteger.valueOf(6)));
    }


    @Test
    @Timeout(value = 3)
    public void superFibonacci(){
        var result = fibo.getFibonacciNumber(BigInteger.valueOf(50) );
        assertEquals(BigInteger.valueOf(12586269025L), result);
    }


    @Test
    @Timeout(value = 6)
    public void thanosFibonacci(){
        var result = fibo.getFibonacciNumber(BigInteger.valueOf(79));
        assertEquals(BigInteger.valueOf(14472334024676221L), result);
    }

}
