package rv.chainofresponsibility.atm;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        MoneyDispenser dispenser;
        Scanner sc = new Scanner(System.in);
        try {
                System.out.println("Please enter the amount to withdraw. Press Ctrl + c to end");
                int amount = sc.nextInt();
                Currency currency = new Currency(new BigDecimal(amount));
                dispenser = new MoneyDispenser(currency);
                dispenser.dispatch();
        } catch (Exception e) {}

        sc.nextLine();
        Bank bank = new Bank("Test bank");
        User user = new User("John", "Doe", "johndoe", "1234", bank);
        Account account = new Account("Savings", user, bank);
        Account checkingAccount = new Account("Checking", user, bank);
        user.addAccount(account);
        user.addAccount(checkingAccount);
        bank.addUser(user, account);
        bank.addUser(user, checkingAccount);

        while (true) {
            User loginUser = loginUser(bank, sc);
            printUserMenu(loginUser, sc);
        }
    }

    public static User loginUser(Bank bank, Scanner scanner) {
        Optional<User> optionalUser;
        do {
            System.out.printf("Welcome to %s\n", bank.getName());
            System.out.println("Enter the username");
            String userName = scanner.nextLine();
            System.out.println("Enter the pin");
            String pin = scanner.nextLine();

            optionalUser = bank.userLogin(userName, pin);
            if (optionalUser.isEmpty()) {
                System.err.println("Invalid username/pin. Please try again");
            }
        } while (optionalUser.isEmpty());

        return optionalUser.get();
    }

    public static void printUserMenu(User user, Scanner scanner) {
        int choice;
        do {
            System.out.printf("Welcome %s, what would you like to do?\n", user.getFirstName());
            System.out.println("  1) Show account transaction history");
            System.out.println("  2) Display Balance");
            System.out.println("  3) Withdraw");
            System.out.println("  4) Deposit");
            System.out.println("  5) Transfer");
            System.out.println("  6) Quit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 6) {
                System.err.println("Invalid choice. Please choose 1-5");
            }

            switch (choice) {
                case 1:
                    showTransactionHistory(user, scanner);
                    break;
                case 2:
                    printAccountBalance(user);
                    break;
                case 3:
                    withdraw(user, scanner);
                    break;
                case 4:
                    deposit(user, scanner);
                    break;
                case 5:
                    transferMoney(user, scanner);
                    break;
            }
        } while (choice > 0 && choice < 6 );
        System.out.println("Goodbye");
        System.exit(0);
    }

    public static void printAccountsSummary(User user) {
        System.out.println("Displaying balances");
        user.printAccountsSummary();
    }

    public static void printAccountBalance(User user) {
        user.getBalance();
    }

    static String getAccountType(Scanner scanner) {
        int account;

        do {
            System.out.println("Enter the account type");
            System.out.println("1. Savings 2. Checking");
            System.out.print("Enter your choice: ");
            account = scanner.nextInt();
            if (account < 1 || account > 2) {
                System.err.println("Invalid account type. Please enter again");
            }
        } while (account < 1 || account > 2);

        return account == 1 ? "Savings" : "Checking";
    }

    public static void showTransactionHistory(User user, Scanner sc) {
        String accountType = getAccountType(sc);
        user.printAccountTransactions(accountType);
    }

    public static void deposit(User user, Scanner scanner) {
        String accountType = getAccountType(scanner);
        System.out.println("Enter the amount to deposit: ");
        BigDecimal amount = scanner.nextBigDecimal();
        boolean status = user.depositMoney(accountType, amount);
        if (status) {
            System.out.println("Money successfully deposited");
        } else {
            System.err.println("Unable to deposit money");
        }
    }

    public static void withdraw(User user, Scanner scanner) {
        String accountType = getAccountType(scanner);
        System.out.println("Enter the amount to withdraw: ");
        BigDecimal amount = scanner.nextBigDecimal();
        boolean status = user.withdrawAmount(accountType, amount);
        if (status) {
            System.out.println("Money successfully withdrawn");
        } else {
            System.err.println("Unable to withdraw money");
        }
    }

    public static void transferMoney(User user, Scanner scanner) {
        System.out.println("Select the account type from which money has to be withdrawn");
        String srcAccountType = getAccountType(scanner);
        System.out.println("Select the account type to which money has to be deposited");
        String destAccountType = getAccountType(scanner);
        if (srcAccountType.equalsIgnoreCase(destAccountType)) {
            System.err.println("From and To accounts cant be same. Please select different account");
            return;
        }
        System.out.println("Enter the amount that has to be transferred");
        BigDecimal amount = scanner.nextBigDecimal();
        boolean status = user.transfer(amount, srcAccountType, destAccountType);
        if (status) {
            System.out.println("Money transferred successfully");
        } else {
            System.err.println("Unable to transfer money");
        }
    }
}
