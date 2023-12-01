package com.vorozco;

public class Calculator {
    public int add(int x, int y) {
        var totalsuma = x + y;
        return totalsuma;
    }

    public int subtract(int x, int y) {
        var totalresta = x - y;
        return totalresta;
    }

    public int multiply(int x, int y) {
        var totalmultiplicacion = x * y;
        return totalmultiplicacion;
    }

    public int divide(int x, int y) {
        var totaldivision = x/y;
        if (y == 0){
            System.out.println("División entre 0 no permitida. SYNTAX ERROR");
        }
        else{
            System.out.println("El resultado de la división es: " + totaldivision );
        }
        return totaldivision;
    }
}
