package by.gsu.pms;

import java.util.Scanner;

public class PercentDiscountPurchase extends AbstractPurchase {
    private double percent;
    public static final int MIN_NUMBER = 5;

    public PercentDiscountPurchase() {
    }

    public PercentDiscountPurchase(Product product, int number, double percent) {
        super(product, number);
        this.percent = percent;
    }

    public PercentDiscountPurchase(Scanner scanner, Product product) {
        this(product, scanner.nextInt(), scanner.nextDouble());
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        if (getNumber() > MIN_NUMBER) {
            baseCost = baseCost.mul(percent / 100, Rounding.FLOOR, 0);
        }
        return baseCost;

    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + percent;
    }
}
