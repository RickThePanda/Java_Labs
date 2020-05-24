package by.gsu.pms;

import java.util.Scanner;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn discount;

    public PriceDiscountPurchase() {
    }

    public PriceDiscountPurchase(Product product, int number, Byn discount) {
        super(product, number);
        this.discount = new Byn(discount);
    }

    public PriceDiscountPurchase(Scanner scanner, Product product) {
        this(product, scanner.nextInt(), new Byn(scanner.nextInt()));
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        int number = getNumber();
        return baseCost.mul(1 / (double) number, Rounding.MATH, 0).sub(discount).mul(number);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
