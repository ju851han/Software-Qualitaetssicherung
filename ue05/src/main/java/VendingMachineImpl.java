public class VendingMachineImpl implements VendingMachine {

    private CashBox cashBox = null;
    private Box[] boxes = null;

    public VendingMachineImpl(CashBox cashBox, Box[] boxes) {
        this.cashBox = cashBox;
        this.boxes = boxes;
    }

    public void selectItem(int boxIndex) throws NotEnoughMoneyException, BoxEmptyException {
        Box box = this.boxes[boxIndex];
        if(box.isEmpty()) {
            throw new BoxEmptyException();
        } else {
            int amountRequired = box.getPrice();
            if(amountRequired > this.cashBox.getCurrentAmount()) {
                throw new NotEnoughMoneyException();
            } else {
                box.releaseItem();
                this.cashBox.withdraw(amountRequired);
            }
        }
    }



}