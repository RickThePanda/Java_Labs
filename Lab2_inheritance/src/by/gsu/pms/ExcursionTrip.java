package by.gsu.pms;

public class ExcursionTrip extends Trip {
    private Excursions place;
    private int cost;

    public ExcursionTrip(int numberOfDays, Transport transport, boolean food, Excursions place, int cost) {
        super(numberOfDays, transport, food);
        this.place = place;
        this.cost = cost;
    }

    public ExcursionTrip(int numberOfDays, Excursions place, int cost) {
        super(numberOfDays);
        this.place = place;
        this.cost = cost;
    }

    public ExcursionTrip(Excursions place, int cost) {
        this.place = place;
        this.cost = cost;
    }

    public ExcursionTrip() {
    }

    public Excursions getPlace() {
        return place;
    }

    public void setPlace(Excursions place) {
        this.place = place;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + place + ";" + cost;
    }
}
