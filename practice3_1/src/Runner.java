import by.gsu.pms.Byn;
import by.gsu.pms.Purchase;
import by.gsu.pms.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("src/in.txt"));
            scanner.useLocale(Locale.ENGLISH);

            final int PURCHASES_NUMBER = 6;
            //1. Create an array for 6 objects.
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            Byn max = new Byn(0);
            int index = 0;
            boolean equals = true;
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                //2. Input data from the given file into the array.
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(scanner);

                //3. Print the array content to the console (one element per line).
                System.out.println(purchases[i]);

                //4. Find the purchase with maximum cost.
                if (purchases[i].getCost().compareTo(max) > 0) {
                    max = purchases[i].getCost();
                    index = i;
                }

                //5. Determine whether all purchases are equal.
                if (equals) {
                    equals = purchases[i].equals(purchases[0]);
                }
            }

            //6. Output results of subtasks 4–5.
            System.out.println("Purchase with maximum cost: " + purchases[index]);
            if (equals) {
                System.out.println("All purchases are equal. ");
            } else {
                System.out.println("Purchases are not equal. ");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found. ");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}