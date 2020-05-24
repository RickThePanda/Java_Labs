package by.gsu.pms;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    public final Product PRODUCT;
    private int number;

    public AbstractPurchase() {
        this(null, 0);
    }

    public AbstractPurchase(Product product, int number) {
        PRODUCT = product;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    protected abstract Byn getFinalCost(Byn baseCost);

    public Byn getCost() {
        Byn baseCost = PRODUCT.PRICE.mul(number);
        Byn finalCost = getFinalCost(baseCost);
        return finalCost.round(Rounding.FLOOR, 2);

    }

    protected String fieldsToString() {
        return Integer.toString(number);
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return o.getCost().compareTo(getCost());
    }
}
