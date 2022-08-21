package com.vorozco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void add() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void subtract() {
        assertEquals(20, calculator.subtract(50, 30));
    }

    @Test
    void multiply() {
        assertEquals(20, calculator.multiply(2, 10));
    }

    @Test
    void divide() {
        assertEquals(2, calculator.divide(50, 25));
    }
}
