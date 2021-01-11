public interface VendingMachine {
    public void selectItem(int boxIndex) throws
            NotEnoughMoneyException,
            BoxEmptyException;
}
