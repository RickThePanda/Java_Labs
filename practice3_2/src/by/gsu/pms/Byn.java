package by.gsu.pms;

public class Byn implements Comparable<Byn> {
    private int amount;

    public Byn(int amount) {
        this.amount = amount;
    }

    public Byn(int rubles, int kopecks) {
        this(rubles * 100 + kopecks);
    }

    public Byn(Byn byn) {
        this(byn.amount);
    }

    public Byn add(Byn byn) {
        return new Byn(amount + byn.amount);
    }

    public Byn sub(Byn byn) {
        return new Byn(amount - byn.amount);
    }

    public Byn mul(int value) {
        return new Byn(amount * value);
    }

    public Byn mul(double value, Rounding rounding, int n) {
        return new Byn(rounding.round(amount * value, n));
    }

    public Byn round(Rounding rounding, int n) {
        return new Byn(rounding.round(amount, n));
    }

    public int getRubs() {
        return amount / 100;
    }

    public int getKopecks() {
        return amount % 100;
    }

    @Override
    public int compareTo(Byn o) {
        return amount - o.amount;
    }

    @Override
    public String toString() {
        return amount / 100 + "." + amount / 10 % 10 + amount % 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return amount == byn.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
