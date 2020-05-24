package by.gsu.pms;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            Purchase getPurchase(Scanner scanner) {
                return new Purchase(scanner);
            }
        }, DISCOUNT_PURCHASE {
            Purchase getPurchase(Scanner scanner) {
                return new DiscountPurchase(scanner);
            }
        }, DISCOUNT_IF_PURCHASE {
            Purchase getPurchase(Scanner scanner) {
                return new DiscountIfPurchase(scanner);
            }
        };

        abstract Purchase getPurchase(Scanner scanner);
    }

    public static Purchase getPurchaseFromFactory(Scanner scanner) {
        String id = scanner.next();
        return PurchaseKind.valueOf(id).getPurchase(scanner);
    }
}
