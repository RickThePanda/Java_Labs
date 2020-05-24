package by.gsu.pms;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind {
        PRICE_DISCOUNT_PURCHASE {
            AbstractPurchase getPurchase(Scanner scanner, Product product) {
                return new PriceDiscountPurchase(scanner, product);
            }
        }, PERCENT_DISCOUNT_PURCHASE {
            AbstractPurchase getPurchase(Scanner scanner, Product product) {
                return new PercentDiscountPurchase(scanner, product);
            }
        }, TRANSPORT_EXPENSES_PURCHASE {
            AbstractPurchase getPurchase(Scanner scanner, Product product) {
                return new TransportExpensesPurchase(scanner, product);
            }
        };

        abstract AbstractPurchase getPurchase(Scanner scanner, Product product);
    }

    public static AbstractPurchase getPurchaseFromFactory(Scanner scanner, Product product) {
        String name = scanner.next();
        return PurchaseKind.valueOf(name).getPurchase(scanner, product);
    }
}