import by.gsu.pms.Milk;

import java.util.Arrays;
import java.util.Comparator;

public class Runner {

    public static void main(String[] args) {

        double fatCounter = 0;
        int count = 0;

        Milk[] milks = {
                new Milk("gomelskoe", 5, true),
                new Milk("minskoe", 15, false),
                new Milk("belakt", 7, true),
                null,
                new Milk("rogachevskoe", 5.5, true),
                new Milk("grodnenskoe", 12.5, false),
                new Milk("babushkina krynka", 3, true),
                new Milk(),
                new Milk("moya slavita", 4.5, true),
                new Milk("prostokvashino", 7.5, true),
        };

        for (Milk milk: milks) {
            if (milk != null){
                milk.show();
            }
        }

        for (Milk milk: milks) {
            if (milk != null && milk.isAvailability()){
                fatCounter += milk.getFatContent();
                count++;
            }
        }

        double average = fatCounter / count;

        System.out.println("Average fat content = " + average);
        System.out.println("Available kinds of milk = " + count);
        System.out.println("\n");

        Arrays.sort(milks, Comparator.comparing(milk -> milk == null ? 0 : milk.getFatContent()));
        for (Milk milk: milks){
            System.out.println(milk);
        }

        System.out.println("\n");

        Arrays.sort(milks, Comparator.comparing(milk -> milk == null ? "" : milk.getName() == null ? "" : milk.getName()));
        for (Milk milk: milks){
            System.out.println(milk);
        }
    }
}
