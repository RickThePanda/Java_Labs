package by.gsu.pms;

public class ShoppingTrip extends Trip {
    private Shops shopName;
    private int cost;

    public ShoppingTrip(int numberOfDays, Transport transport, boolean food, Shops shopName, int cost) {
        super(numberOfDays, transport, food);
        this.shopName = shopName;
        this.cost = cost;
    }

    public ShoppingTrip(int numberOfDays, Shops shopName, int cost) {
        super(numberOfDays);
        this.shopName = shopName;
        this.cost = cost;
    }

    public ShoppingTrip(Shops shopName, int cost) {
        this.shopName = shopName;
        this.cost = cost;
    }

    public ShoppingTrip(){
    }

    public Shops getShopName() {
        return shopName;
    }

    public void setShopName(Shops shopName) {
        this.shopName = shopName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return  super.toString() + ";" + shopName + ";" + cost;
    }
}
