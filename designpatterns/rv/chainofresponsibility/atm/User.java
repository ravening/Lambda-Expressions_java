package rv.chainofresponsibility.atm;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class User {
    private String firstName;
    private String lastName;
    private String uuid;
    private String userName;
    private byte pinHash[];
    private List<Account> accounts;

    public User(String firstName, String lastName, String userName, String pin, Bank bank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        }catch (NoSuchAlgorithmException e) {
            System.err.println("Unable to encode pin. so such algorithm");
            System.exit(1);
        }
        this.uuid = bank.getNewUserUUId();

        this.accounts = new ArrayList<>();
        System.out.println("New User created " + this.toString());
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUserName() {
        return userName;
    }

    public byte[] getPinHash() {
        return pinHash;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", uuid='" + uuid + '\'' +
                ", userName='" + userName + '\'' +
                ", pinHash=" + Arrays.toString(pinHash) +
                ", accounts=" + accounts +
                '}';
    }

    public void printAccountsSummary() {
        accounts.forEach(System.out::println);
    }

    public void getBalance() {
        accounts.forEach(a -> System.out.println("Balance in " + a.getAccountType() + " account is " + a.getBalance()));
    }

    private Optional<Account> getAccountByAccountType(String accountType) {
        AccountType type = AccountType.getAccountType(accountType);
        return this.accounts.stream()
                .filter(account -> account.getAccountType().equals(type))
                .findFirst();
    }

    public void printAccountTransactions(String accountType) {
        Optional<Account> account = getAccountByAccountType(accountType);
        account.ifPresent(value -> value.getTransactions().forEach(System.out::println));
    }

    public boolean depositMoney(String accountType, BigDecimal amount) {
        Optional<Account> account = getAccountByAccountType(accountType);
        if (account.isPresent()) {
            Transaction transaction = new Transaction(amount, "Deposit to own account", account.get());
            account.get().addTransaction(transaction);
            account.get().increaseBalance(amount);
        } else {
            System.err.println("Account does not exist");
            return false;
        }

        return true;
    }

    public boolean withdrawAmount(String accountType, BigDecimal amount) {
        Optional<Account> account = getAccountByAccountType(accountType);
        if (account.isPresent()) {
            Account account1 = account.get();
            if (account1.getBalance().compareTo(amount) < 0) {
                System.err.println("You dont have sufficient balance to withdraw");
                return false;
            }
            Transaction transaction = new Transaction(amount, "Withdraw from account", account1);
            account1.addTransaction(transaction);
            account1.decreaseBalance(amount);
        } else {
            System.err.println("Account does not exist");
            return false;
        }

        return true;
    }

    public boolean transfer(BigDecimal amount, String fromAccountType, String toAccountType) {
        Optional<Account> sourceAccountOptional = getAccountByAccountType(fromAccountType);
        Optional<Account> destAccountOptional = getAccountByAccountType(toAccountType);
        if (sourceAccountOptional.isPresent()) {
            Account sourceAccount = sourceAccountOptional.get();
            if (sourceAccount.getBalance().compareTo(amount) < 0) {
                System.err.println("Source account doesnt have sufficient balance to withdraw");
                return false;
            }
            if (destAccountOptional.isEmpty()) {
                System.err.println("Destination account does not exist");
                return false;
            }
            Account destAccount = destAccountOptional.get();
            Transaction transaction = new Transaction(amount, "Transfer from " +fromAccountType + " to " + toAccountType,
                    sourceAccount, destAccount);
            sourceAccount.addTransaction(transaction);
            Transaction transaction1 = new Transaction(amount, "Transfer from " + fromAccountType + " to " + toAccountType, destAccount, sourceAccount);
            destAccount.addTransaction(transaction1);
            sourceAccount.decreaseBalance(amount);
            destAccount.increaseBalance(amount);
        }
        return true;
    }
}
