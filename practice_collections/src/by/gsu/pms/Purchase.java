package by.gsu.pms;

public class Purchase implements Comparable<Purchase> {

    private String name;
    private int price;
    private int number;

    public Purchase(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCost(){
        return number * price;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + number + ";" + getCost();
    }

    @Override
    public int compareTo(Purchase o) {
        return Integer.compare(this.getCost(), o.getCost());
    }
}
