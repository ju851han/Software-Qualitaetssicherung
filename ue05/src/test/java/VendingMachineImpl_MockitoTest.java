import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Aufgabe 2b
 */
public class VendingMachineImpl_MockitoTest {
    @Mock
    private CashBox cashBox;
    @Mock
    private Box box;
    @InjectMocks
    VendingMachineImpl vendingMachine;

    @Before
    public void setUp() {
    cashBox = Mockito.mock(CashBox.class);
    box = Mockito.mock(Box.class);
    vendingMachine = new VendingMachineImpl(cashBox,new Box[]{box});
    }

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
