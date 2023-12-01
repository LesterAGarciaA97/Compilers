package com.vorozco;

import java.math.BigInteger;


public class FibonacciCreator {

    public BigInteger getFibonacciNumber(BigInteger n){
        if (n.intValue() < 1){
            return null;
        }
        BigInteger L = BigInteger.valueOf(0);
        BigInteger C = BigInteger.valueOf(1);

        int R = n.intValue();
        while(R-- > 1){
            C = C.add(L);
            L = C.subtract(L);
        }
        return C;
    }
        /*if(n == BigInteger.valueOf(0)){
            return BigInteger.valueOf(0);
        }
        if(BigInteger.ONE.equals(n) || BigInteger.valueOf(2).equals(n)){
            return BigInteger.ONE;
        }
        return getFibonacciNumber( n.subtract(BigInteger.valueOf(2)) ).add(getFibonacciNumber(n.subtract(BigInteger.ONE)));
    }
*/
}
