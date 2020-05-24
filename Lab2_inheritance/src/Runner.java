import by.gsu.pms.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Trip[] trips = {
                new ResortTrip(5, Transport.TRAIN, true, Resorts.Egypt, 50),
                new ResortTrip(7, Transport.PLANE, false, Resorts.Bulgaria, 30),
                new ResortTrip(12, Transport.CAR, true, Resorts.Turkey, 40),
                new ExcursionTrip(6, Transport.TRAIN, false, Excursions.PARIS, 1500),
                new ExcursionTrip(7, Transport.PLANE, false, Excursions.LONDON, 2000),
                new ExcursionTrip(5, Transport.CAR, false, Excursions.MOSCOW, 800),
                new ShoppingTrip(3, Transport.TRAIN, false, Shops.CHANEL, 5000),
                new ShoppingTrip(2, Transport.PLANE, false, Shops.ARMANI, 7000),
                new ShoppingTrip(3, Transport.CAR, false, Shops.GUCCI, 3000)
        };

        for (Trip trip : trips) {
            System.out.println(trip);
        }

        System.out.println("\nSorting by number of days:\n");

        Arrays.sort(trips, Comparator.comparing(trip -> trip == null ? 0 : trip.getNumberOfDays()));
        for (Trip trip : trips) {
            System.out.println(trip);
        }
    }
}
