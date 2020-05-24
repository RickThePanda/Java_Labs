package by.gsu.pms;

import java.util.Scanner;

public class DiscountPurchase extends Purchase {
    private Byn discount;

    public DiscountPurchase() {}

    public DiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public DiscountPurchase(Scanner scanner) {
        super(scanner);
        discount = new Byn(scanner.nextInt());
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return new Byn(getPrice()).sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
