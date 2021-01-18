import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Aufgabe 3
 * Spy: ersetzt echte Komponente, um indirekte Ausgabe durch Aufnahme (Recording) zu kontrollieren
 * Methoden der Klasse des TestSpys werden überschrieben mit (anderer) Logik
 * Der Spion dient also als Wrapper und leitet, sofern nichts anderes konfiguriert wurde,
 * alle Methodenaufrufe an ein echtes Objekt weiter.
 */
@RunWith(MockitoJUnitRunner.class)
public class VendingMachineImpl_Spy {

    private VendingMachineImpl vendingMachine;
    private CashBox cashBox;
    private Box box;

    @Before
    public void setUp() {
        cashBox = new CashBox() {
            private int amount = 100;

            public int getCurrentAmount() {
                return amount;
            }

            public void withdraw(int amountRequired) {
                this.amount = amount + amountRequired;
            }
        };
    }

    /**
     * Test für getCurrentAmount() mittels Verify
     * @throws BoxEmptyException
     * @throws NotEnoughMoneyException
     */
    @Test
    public void test_verifyGetCurrentAmount() throws BoxEmptyException, NotEnoughMoneyException {
        CashBox mockCashBox = spy(cashBox);
        vendingMachine = new VendingMachineImpl(mockCashBox, new FullBox[]{new FullBox()});
        mockCashBox.withdraw(20);
//        mockCashBox.getCurrentAmount();
        verify(mockCashBox, times(0)).getCurrentAmount();
        vendingMachine.selectItem(0);
        //verify(vendingMachine,times(0)).selectItem(0); --> funktioniert nicht, da vendingMachine != mockItem
    }

    /**
     * Test für getCurrentAmount() mittels Assert
     */
    @Test
    public void test_assertGetCurrentAmount() throws BoxEmptyException, NotEnoughMoneyException {
        CashBox spyCashBox = spy(cashBox);
        vendingMachine = new VendingMachineImpl(spyCashBox, new Box[]{box}); //?
        Assert.assertEquals(spyCashBox.getCurrentAmount(), 100);
    }
}
