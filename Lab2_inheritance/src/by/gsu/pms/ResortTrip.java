package by.gsu.pms;

public class ResortTrip extends Trip {
    private Resorts country;
    private int costPerDay;

    public ResortTrip(int numberOfDays, Transport transport, boolean food, Resorts country, int costPerDay) {
        super(numberOfDays, transport, food);
        this.country = country;
        this.costPerDay = costPerDay;
    }

    public ResortTrip(int numberOfDays, Resorts country, int costPerDay) {
        super(numberOfDays);
        this.country = country;
        this.costPerDay = costPerDay;
    }

    public ResortTrip(Resorts country, int costPerDay) {
        this.country = country;
        this.costPerDay = costPerDay;
    }

    public ResortTrip() {
    }

    public Resorts getCountry() {
        return country;
    }

    public void setCountry(Resorts country) {
        this.country = country;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public int getCost(int numberOfDays, int costPerDay){
        return numberOfDays * costPerDay;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + country + ";" + getCost(super.getNumberOfDays(), costPerDay);
    }
}
