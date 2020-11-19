package swqs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ICalculatorTest {
    private static ICalculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        calc = null;
    }

    /*************************** Tests für Summe ***********************************/

    /**
     * Test für einfache Summenbildung
     */
    @Test
    public void sum() {
        assertEquals(10, calc.sum(5, 5));
    }

    /**
     * Test für Summe von Nichts
     */
    @Test
    public void sumZero() {
        assertEquals(0, calc.sum());
    }

    /**
     * Test für Summe von negativen und positiven Summanden
     */
    @Test
    public void sumNegative() {
        assertEquals(-20, calc.sum(-50, 30));
    }

    /**
     * Test für Summe aus NULL
     */
    @Test
    public void sumNull() {
        assertNotNull(calc.sum(null));
    }

    /**
     * Test für Summe von Buchstaben
     * Ziel: Ergebnis soll kein NULL zurückliefern
     * Hinweis: char wird zum int aufgrund des Übergabeparameterdatentyps upgecastet
     */
    @Test
    public void sumLetter() {
        assertNotNull(calc.sum('A', 'B'));
    }

    /**
     * Test für Summe von Überschreitung des Maximallimits bei Integer +1
     * Hinweis: Rückgabewert war davor int statt long; Dadurch kam es zum Überlauf und Ergebnis war -2147483648.
     */
    @Test
    public void sumOverIntegerLimit() {
        assertNotEquals(-2147483648, calc.sum(2147483647, 1));
    }

    /*************************** Tests für Multiplikation ***********************************/

    /**
     * Test für einfache Multiplikation
     */
    @Test
    public void mul() {
        assertEquals(25, calc.mul(5, 5));
    }

    /**
     * Test für Multiplikation von Nichts
     * Hinweis: Ursprünglich wurde 1 als Ergebnis zurückgeliefert.
     * Daher wurde mul() Methode erweitert mit values.length>0
     */
    @Test
    public void mulNothing() {
        assertEquals(0, calc.mul());
    }

    /**
     * Test für Multiplikation von negativen und positiven Zahlen
     */
    @Test
    public void mulNegative() {
        assertEquals(-1500, calc.mul(-50, 30));
    }

    /**
     * Test für Multiplikation aus NULL
     */
    @Test
    public void mulNull() {
        assertNotNull(calc.mul(null));
    }

    /**
     * Test für Multiplikation mit Null als Faktor
     */
    @Test
    public void mulZero() {
        assertEquals(0, calc.mul(20,40,0,50));
    }

    /**
     * Test für Multiplikation von Buchstaben
     * Ziel: Ergebnis soll kein NULL zurückliefern
     * Hinweis: char wird zum int aufgrund des Übergabeparameterdatentyps upgecastet
     */
    @Test
    public void mulLetter() {
        assertNotNull(calc.mul('A', 'B'));
    }

    /**
     * Test für mulme von Überschreitung des Maximallimits bei Integer +1
     * Hinweis: Rückgabewert war davor int statt long; Dadurch kam es zum Überlauf und Ergebnis war -2.
     */
    @Test
    public void mulOverIntegerLimit() {
        assertNotEquals(-2, calc.mul(2147483647, 2));
    }

    /*************************** Tests für Multiplikation + Summe kombiniert ***********************************/

    /**
     * Test für Multiplikation und anschließende Summe von zwei Zahlen
     */
    @Test
    public void mulSum(){
        assertEquals(18, calc.mul((int)calc.sum(7,2),2));
    }

    /**
     * Test für Summe und anschließende Multiplikation von zwei Zahlen
     */
    @Test
    public void sumMul(){
        assertEquals(16, calc.sum((int)calc.mul(7,2),2));
    }
}