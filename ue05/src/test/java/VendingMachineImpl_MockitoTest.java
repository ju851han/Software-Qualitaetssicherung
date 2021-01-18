import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


/**
 * Aufgabe 2b
 * Mock Object: ersetzt echte Komponente, um indirekte Ausgabe zu kontrollieren,
 * immitiert (bzw. täuschen vor) ein bestimmtes Verhalten und
 * vergleicht aktuelle empfangene Aufrufe mit vorher definierten Erwartungen mit Nutzung von Assertions
 */
@RunWith(MockitoJUnitRunner.class)
public class VendingMachineImpl_MockitoTest {

    /**
     * @Mock erstellt Mocks
     * @InjectMocks erstellt Objekt und injiziert gemockte Abhängigkeiten
      */
    @Mock
    private CashBox cashBox;
    @Mock
    private Box box;
    @InjectMocks
    VendingMachineImpl vendingMachine;

    /**
     * setUp() wird vor dem Test ausgeführt
     */
    @Before
    public void setUp() {
    cashBox = Mockito.mock(CashBox.class);
    box = Mockito.mock(Box.class);
    vendingMachine = new VendingMachineImpl(cashBox,new Box[]{box});
    }

    /**
     * Testet, ob eine Exception geworfen wird
     * @throws BoxEmptyException
     * @throws NotEnoughMoneyException
     */

    @Test
    public void test_selectItem() throws BoxEmptyException, NotEnoughMoneyException {
        Mockito.when(cashBox.getCurrentAmount()).thenReturn(42);

        Mockito.when(box.isEmpty()).thenReturn(Boolean.FALSE);
        Mockito.when(box.getPrice()).thenReturn(42);

        vendingMachine.selectItem(0);
        Mockito.verify(box).releaseItem();
        Mockito.verify(cashBox).withdraw(42);
    }
}
