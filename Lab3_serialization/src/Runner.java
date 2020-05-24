import serialization.Deserialization;
import by.gsu.pms.Milk;
import serialization.Serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        double fatCounter = 0;
        int count = 0;

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("src\\in.txt"));
            final int length = scanner.nextInt();
            Milk[] milks = new Milk[length];
            for (int i = 0; i < length; i++) {
                milks[i] = new Milk(
                        scanner.next(),
                        Double.parseDouble(scanner.next()),
                        scanner.nextBoolean()
                );
            }

            for (Milk milk : milks) {
                if (milk != null) {
                    milk.show();
                }
            }

            Serialization serialization = new Serialization();
            serialization.serialization(milks);

            Milk[] newMilk;
            Deserialization deserialization = new Deserialization();
            newMilk = deserialization.deserialization();

            System.out.println("\nAfter serialization:");
            for (Milk milk : milks) {
                System.out.println(milk);
            }

            for (Milk milk : milks) {
                if (milk != null && milk.isAvailability()) {
                    fatCounter += milk.getFatContent();
                    count++;
                }
            }

            double average = fatCounter / count;

            System.out.println("\nAverage fat content = " + average);
            System.out.println("Available kinds of milk = " + count);
            System.out.println("\n");

            Arrays.sort(milks, Comparator.comparing(milk -> milk == null ? 0 : milk.getFatContent()));
            for (Milk milk : milks) {
                System.out.println(milk);
            }

            System.out.println("\n");

            Arrays.sort(milks, Comparator.comparing(milk -> milk == null ? "" : milk.getName() == null ? "" : milk.getName()));
            for (Milk milk : milks) {
                System.out.println(milk);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
