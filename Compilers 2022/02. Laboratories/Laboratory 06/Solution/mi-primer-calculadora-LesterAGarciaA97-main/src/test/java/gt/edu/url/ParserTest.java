package gt.edu.url;

import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void testOriginal() throws Exception {
        String cadena = "2+2*6";
        MyParser p = new MyParser(new MyLexer(new StringReader(cadena)));
        assertEquals(14.0, (double) p.parse().value, 0.0001);
    }

    @Test
    public void testParentesis() throws Exception {
        String cadena = "(2+2)*(6-5)";
        MyParser p = new MyParser(new MyLexer(new StringReader(cadena)));
        assertEquals(4.0, (double) p.parse().value, 0.0001);
    }

    @Test
    public void testDivision() throws Exception {
        String cadena = "30/3/5";
        MyParser p = new MyParser(new MyLexer(new StringReader(cadena)));
        assertEquals(2.0, (double) p.parse().value, 0.0001);
    }

    @Test
    public void testMod() throws Exception {
        String cadena = "5%2";
        MyParser p = new MyParser(new MyLexer(new StringReader(cadena)));
        assertEquals(1.0, (double) p.parse().value, 0.0001);
    }

    @Test
    public void testMultiplicacion() throws Exception {
        String cadena = "7*7*8";
        MyParser p = new MyParser(new MyLexer(new StringReader(cadena)));
        assertEquals(392.0, (double) p.parse().value, 0.0001);
    }

    @Test
    public void testAcumulacion() throws Exception {
        String cadena = "(++7)-1";
        MyParser p = new MyParser(new MyLexer(new StringReader(cadena)));
        assertEquals(7.0, (double) p.parse().value, 0.0001);
    }
}
