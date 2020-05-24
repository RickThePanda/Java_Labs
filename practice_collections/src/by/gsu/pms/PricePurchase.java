package by.gsu.pms;

public class PricePurchase extends Purchase {

    private int discount;

    public PricePurchase(String name, int cost, int count, int discount) {
        super(name, cost, count);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + discount;
    }

    @Override
    public int getCost(){
        return getNumber() * (getPrice()-discount);
    }
}
