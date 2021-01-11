public class UnlimitedCashBox implements CashBox {

    public int getCurrentAmount() {
        return Integer.MAX_VALUE;
    }

    public void withdraw(int amountRequired) {
    }

}