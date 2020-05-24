package by.gsu.pms;

public class Milk {
    private String name;
    private double fatContent;
    private boolean availability;

    public Milk() {
    }

    public Milk(String name, double fatContent, boolean availability) {
        this.name = name;
        this.fatContent = fatContent;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFatContent() {
        return fatContent;
    }

    public void setFatContent(double fatContent) {
        this.fatContent = fatContent;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void show() {
        System.out.println("Name = " + name);
        System.out.println("Fat Content = " + fatContent);
        if (availability) {
            System.out.println("Available");
        } else System.out.println("Not Available");
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return name + ";" + fatContent;
    }
}
