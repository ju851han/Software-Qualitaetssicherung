package swqs;

public interface ICalculator {

    /**
     * Summiert alle übergebenen Werte
     * @param values Integer-Werte ; int... = variable Parameteranzahl
     * @return Summe aller übergebenen Integer-Werte
     */
    public long sum(int... values);

    /**
     * Subtrahiert alle übergebenen Werte
     * @param values Integer-Werte ; int... = variable Parameteranzahl
     * @return Differenz aller übergebenen Integer-Werte
     */
    public long sub (int... values);

    /**
     * Multipliziert alle übergebenen Werte
     * @param values Integer-Werte; int... = variable Parameteranzahl
     * @return Produkt aller übergebenen Integer-Werte
     */
    public long mul(int... values);

    /**
     * Dividiert alle übergebenen Werte
     * Hinweis: 1. Zahl / 2. Zahl / 3. Zahl / 4. Zahl etc.
     * @param dividend Zahl über den Bruchstrich; Integer-Wert
     * @param divsor Zahl unter dem Bruchstrich; Integer-Werte ; int... = variable Parameteranzahl
     * @return Quotient
     */
    public float div(int dividend, int... divsor);






}
