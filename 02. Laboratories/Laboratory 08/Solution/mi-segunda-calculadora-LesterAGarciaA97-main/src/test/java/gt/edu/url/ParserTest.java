package gt.edu.url;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void testOriginal() throws Exception {
        String cadena = "2+2*6";
        MyParser p = new MyParser();
        assertEquals(14.0, p.evalExp(cadena), 0.0001);
    }

    @Test
    public void testParentesis() throws Exception {
        String cadena = "(2+2)*(6-5)";
        MyParser p = new MyParser();
        assertEquals(4.0, p.evalExp(cadena), 0.0001);
    }

    @Test
    public void testDivision() throws Exception {
        String cadena = "30/3/5";
        MyParser p = new MyParser();
        assertEquals(2.0, p.evalExp(cadena), 0.0001);
    }

    @Test
    public void testMod() throws Exception {
        String cadena = "5%2";
        MyParser p = new MyParser();
        assertEquals(1.0, p.evalExp(cadena), 0.0001);
    }

    @Test
    public void testMultiplicacion() throws Exception {
        String cadena = "7*7*8";
        MyParser p = new MyParser();
        assertEquals(392.0, p.evalExp(cadena), 0.0001);
    }

    @Test
    public void testAcumulacion() throws Exception {
        String cadena = "(++7)-1";
        MyParser p = new MyParser();
        assertEquals(7.0, p.evalExp(cadena), 0.0001);
    }

    @Test
    public void testPotencia() throws Exception {
        String cadena = "3**3";
        MyParser p = new MyParser();
        assertEquals(27.0, p.evalExp(cadena), 0.0001);
    }
}
