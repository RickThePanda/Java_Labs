package by.gsu.pms;

import java.util.Scanner;

public class Product {
    public final String NAME;
    public final Byn PRICE;

    public Product() {
        this(null, null);
    }

    public Product(String name, Byn price) {
        NAME = name;
        PRICE = price;
    }

    public Product(Scanner scanner) {
        this(scanner.next(), new Byn(scanner.nextInt()));
    }

    @Override
    public String toString() {
        return NAME + ";" + PRICE;
    }
}
