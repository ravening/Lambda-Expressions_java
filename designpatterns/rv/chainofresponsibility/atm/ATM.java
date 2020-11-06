package rv.chainofresponsibility.atm;

import java.math.BigDecimal;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        MoneyDispenser dispenser;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Please enter the amount to withdraw. Press Ctrl + c to end");
                int amount = scanner.nextInt();
                Currency currency = new Currency(new BigDecimal(amount));
                dispenser = new MoneyDispenser(currency);
                dispenser.dispatch();
            } while (true);
        }
    }
}
