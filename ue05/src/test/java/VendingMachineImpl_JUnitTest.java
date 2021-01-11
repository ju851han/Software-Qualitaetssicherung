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

    /**
     * setUp() wird vor dem Test ausgeführt
     */
    @Before
    public void setUp() {
        vendingMachine = new VendingMachineImpl(new UnlimitedCashBox(), new Box[]{new FullBox()});
    }

    /**
     * Regel: Es wird erwartet, dass keine Exception geworfen wird
     */
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    /**
     * Testet, ob eine Exception geworfen wird
     * @throws Exception
     */
    @Test
    public void testselectItem() throws Exception {
        vendingMachine.selectItem(0);
    }
}

