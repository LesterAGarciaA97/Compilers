package com.vorozco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FraseTest {

    Frase frase;

    @BeforeEach
    public void init(){
        frase = new Frase();
    }

    @Test
    public void paco(){
        assertEquals("juan paco pedro de la mar", frase.doPaco());
    }

    @Test
    public void fraseReversa(){
        assertEquals("Landivar Rafael Universidad", frase.doFraseReversa("Universidad Rafael Landivar"));
    }

    @Test
    public void palindromo(){
        assertTrue(frase.doPalindromo("A luna ese anula"));
        assertFalse(frase.doPalindromo("Tres tristes tigres tragan trigo en un triste trigal"));
    }

    @Test
    public void mayusculas(){
        assertEquals("JUAN PEDRO DE LA MAR", frase.doMayusculas("juan paco pedro de la mar"));
    }

}
