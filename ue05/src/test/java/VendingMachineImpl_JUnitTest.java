import org.junit.After;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Aufgabe 2a
 * Alternative Lösung: in selectItem() Methode ein return true hinzufügen & Rückgabewert auf boolean setzen
 * und den Test mittels assertTrue(vendingMachine.selectItem(0)); auszuführen
 */
public class VendingMachineImpl_JUnitTest {
    private VendingMachineImpl vendingMachine; // = System Under Test

    @Before
    public void setUp() {
        vendingMachine = new VendingMachineImpl(new UnlimitedCashBox(), new Box[]{new FullBox()});
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     * source: https://www.baeldung.com/junit-assert-exception
     */
    @Test
    public void testselectItem() throws Exception {
        vendingMachine.selectItem(0);
    }
}

