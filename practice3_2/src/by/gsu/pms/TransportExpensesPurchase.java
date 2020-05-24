package by.gsu.pms;

import java.util.Scanner;

public class TransportExpensesPurchase extends AbstractPurchase {
    private Byn transportExpenses;

    public TransportExpensesPurchase() {
    }

    public TransportExpensesPurchase(Product product, int number, Byn transportExpenses) {
        super(product, number);
        this.transportExpenses = new Byn(transportExpenses);
    }

    public TransportExpensesPurchase(Scanner scanner, Product product) {
        this(product, scanner.nextInt(), new Byn(scanner.nextInt()));
    }

    public Byn getTransportExpenses() {
        return transportExpenses;
    }

    public void setTransportExpenses(Byn transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        return baseCost.add(transportExpenses);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpenses;
    }
}
