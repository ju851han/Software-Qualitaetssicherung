package swqs;

public class Calculator implements ICalculator {

    /**
     * Summiert alle übergebenen Werte
     * @param values Integer-Werte ; int... = variable Parameteranzahl
     * @return Summe aller übergebenen Integer-Werte
     */
    @Override
    public long sum(int... values) {
        long sum = 0;
        if (values != null) {
            for (int aValue : values) {
                sum += aValue;
            }
        }
        return sum;
    }

    /**
     * Subtrahiert alle übergebenen Werte
     *
     * @param values Integer-Werte ; int... = variable Parameteranzahl
     * @return Differenz aller übergebenen Integer-Werte
     */
    @Override
    public long sub(int... values) {
        return 0;
    }

    /**
     * Multipliziert alle übergebenen Werte
     *
     * @param values Integer-Werte; int... = variable Parameteranzahl
     * @return Produkt aller übergebenen Integer-Werte
     */
    @Override
    public long mul(int... values) {
        return 0;
    }

    /**
     * Dividiert alle übergebenen Werte
     * Hinweis: 1. Zahl / 2. Zahl / 3. Zahl / 4. Zahl etc.
     *
     * @param dividend Zahl über den Bruchstrich; Integer-Wert
     * @param divsor   Zahl unter dem Bruchstrich; Integer-Werte ; int... = variable Parameteranzahl
     * @return Quotient
     */
    @Override
    public float div(int dividend, int... divsor) {
        return 0;
    }

}
