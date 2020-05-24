package by.gsu.pms;

public class BusinessTrip {
    private static final int DAILY_ALLOWANCE_RATE = 700;
    private String account;
    private int transportExpenses;
    private int numberOfDays;

    public BusinessTrip() {
    }

    public BusinessTrip(String account, int transportExpenses, int numberOfDays) {
        this.account = account;
        this.transportExpenses = transportExpenses;
        this.numberOfDays = numberOfDays;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransportExpenses() {
        return transportExpenses;
    }

    public void setTransportExpenses(int transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getTotal() {
        return transportExpenses + DAILY_ALLOWANCE_RATE * numberOfDays;
    }

    public void show() {
        System.out.println("rate = " + DAILY_ALLOWANCE_RATE + '\n'
                + "account = " + account + '\n'
                + "transportExpenses = " + transportExpenses + '\n'
                + "numberOfDays = " + numberOfDays + '\n'
                + "total = " + getTotal() + '\n');
    }

    @Override
    public String toString() {
        return account + ';'
                + transportExpenses + ';'
                + numberOfDays + ';'
                + getTotal();
    }
}
