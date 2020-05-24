import by.gsu.pms.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    private static void output(AbstractPurchase[] abstractPurchases, Product product) {
        System.out.println(product);
        for (AbstractPurchase abstractPurchase : abstractPurchases) {
            System.out.println(abstractPurchase);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("src/in0.txt"));
            scanner.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = 6;

            //1. Create the unique product for purchasing.
            final Product PRODUCT = new Product(scanner);

            //2. Create an array for 6 objects.
            AbstractPurchase[] purchases = new AbstractPurchase[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(scanner, PRODUCT);
            }

            //3. Print the array content to the console (one element per line).
            output(purchases, PRODUCT);

            //4. Sort an array by the cost in descending order by the method sort( ) of the class Arrays.
            System.out.println("\nSorted array: ");
            Arrays.sort(purchases);

            //5. Print the array content to the console (one element per line).
            output(purchases, PRODUCT);

            //6. Print the minimum cost of purchase.
            System.out.println("\nMinimum cost = " + purchases[PURCHASES_NUMBER - 1].getCost());

            //7. Find some purchase with cost equaled to 5.00 BYN by the method binarySearch( ) of the class Arrays and print it.
            int position = Arrays.binarySearch(purchases, new PriceDiscountPurchase(new Product(null, new Byn(500)),1, new Byn(0)));
            if (position < 0) {
                System.out.println("Required purchase is not found. ");
            } else {
                System.out.println("Purchase with cost = 5: " + purchases[position]);
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