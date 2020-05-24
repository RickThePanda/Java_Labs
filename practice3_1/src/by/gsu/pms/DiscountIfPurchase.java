package by.gsu.pms;

import java.util.Scanner;

public class DiscountIfPurchase extends Purchase {
    private double percent;
    public static final int MIN_NUMBER = 5;

    public DiscountIfPurchase() {}

    public DiscountIfPurchase(String name, Byn price, int number, double percent) {
        super(name, price, number);
        this.percent = percent;
    }

    public DiscountIfPurchase(Scanner scanner) {
        super(scanner);
        percent = scanner.nextDouble();
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        if (getNumber() > MIN_NUMBER) {
            cost.mul(1 - percent / 100, Rounding.MATH, 0);
        }
        return cost;
    }


    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + percent;
    }
}