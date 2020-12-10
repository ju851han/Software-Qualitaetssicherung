import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Aufgabe 2 b
 */
public class MyStringTest {
    /**
     * Subject under Test (SUT) vom 4-Phasen-Testmuster
     */
    private static MyString myString;

    /**
     * 1. Phase vom 4-Phasen-Testmuster: SETUP
     * setUp() wird ausgeführt, BEVOR der Test gestartet wird
     */
    @Before
    public void setUp() {
        myString = new MyString("a");
    }

    /**
     * 4. Phase vom 4-Phasen-Testmuster: TEARDOWN
     * tearDown() wird ausgeführt, NACHDEM der Test ausgeführt wurde.
     * (Aufräumen)
     */
    @After
    public void tearDown() {
        myString = null;
    }

    /**
     * 2.+3. Phase vom 4-Phasen-Testmuster: EXERCISE (=.equals) + VERIFY (=Assert.assertFalse)
     */
    @Test
    public void testDifferentDigits() {
        Object o = new MyString("b");
        Assert.assertFalse(myString.equals(o));
    }

    /**
     * 2.+3. Phase vom 4-Phasen-Testmuster: EXERCISE (=.equals) + VERIFY (=Assert.assertTrue)
     * HINWEIS: Test für selbe Länge ist nicht benötigt, da wenn die MyStrings dieselben Zeichen beinhalten, dann werden sie auch dieselbe Länge haben
     */
    @Test
    public void testSameDigits() {
        Object o = new MyString("a");
        Assert.assertTrue(myString.equals(o));
    }

    /**
     * 2.+3. Phase vom 4-Phasen-Testmuster: EXERCISE (=.equals) + VERIFY (=Assert.assertFalse)
     */
    @Test
    public void testDifferentLength() {
        Object o = new MyString("ba");
        Assert.assertFalse(myString.equals(o));
    }

    /**
     * 2.+3. Phase vom 4-Phasen-Testmuster: EXERCISE (=.equals) + VERIFY (=Assert.assertFalse)
     */
    @Test
    public void testNoInstanceOfMyString() {
        String str = "a";
        Assert.assertFalse(myString.equals(str));
    }

    /**
     * 2.+3. Phase vom 4-Phasen-Testmuster: EXERCISE (=.equals) + VERIFY (=Assert.assertTrue)
     */
    @Test
    public void testSameObject() {
        Assert.assertTrue(myString.equals(myString));

    }
}
