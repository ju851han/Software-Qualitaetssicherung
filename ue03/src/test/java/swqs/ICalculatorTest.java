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
}