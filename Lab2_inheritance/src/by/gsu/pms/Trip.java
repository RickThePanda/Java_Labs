package by.gsu.pms;

public class Trip {
    private int numberOfDays;
    private Transport transport;
    private boolean food;

    public Trip(int numberOfDays, Transport transport, boolean food) {
        this.numberOfDays = numberOfDays;
        this.transport = transport;
        this.food = food;
    }

    public Trip(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Trip() {
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return  numberOfDays + ";" + transport + ";" + food;
    }
}
