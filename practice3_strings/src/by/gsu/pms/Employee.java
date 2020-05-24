package by.gsu.pms;

public class Employee {
    private static final int DAILY_ALLOWANCE_RATE = 1600;
    private String account;
    private int transportExpenses;
    private int days;

    public Employee(String account, int transportExpenses, int days) {
        this.account = account;
        this.transportExpenses = transportExpenses;
        this.days = days;
    }

    public Employee() {
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public float getTotal() {
        return days == 1 ? transportExpenses : DAILY_ALLOWANCE_RATE * days + transportExpenses;
    }

    public void show() {
        System.out.println("Rate = " + DAILY_ALLOWANCE_RATE);
        System.out.println("Account = " + account);
        System.out.println("Transport Expenses = " + transportExpenses);
        System.out.println("Days = " + days);
        System.out.println("Total = " + getTotal());
    }

    @Override
    public String toString() {
        return DAILY_ALLOWANCE_RATE + ";" + account + ";" + transportExpenses + ";" + days + ";" + getTotal();
    }
}
