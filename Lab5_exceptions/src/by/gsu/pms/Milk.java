package by.gsu.pms;

import exceptions.EmptyNameException;
import exceptions.NegativeValueException;

import java.io.Serializable;

public class Milk implements Serializable {
    private String name;
    private double fatContent;
    private boolean availability;

    public Milk() {
    }

    public Milk(String name, double fatContent, boolean availability) throws EmptyNameException, NegativeValueException {
        if(name.equals("")){
            throw new EmptyNameException("Milk must have a name");
        }
        if(fatContent < 0){
            throw new NegativeValueException("Fat content cannot be negative");
        }
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
