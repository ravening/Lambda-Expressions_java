package rv.chainofresponsibility.atm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private AccountType accountType;
    private BigDecimal balance;
    private String uuid;
    private User holder;
    private List<Transaction> transactions;

    public Account(String accountType, User holder, Bank bank) {
        this.accountType = AccountType.getAccountType(accountType);
        this.holder = holder;
        this.uuid = bank.getNewAccountUUId();
        this.transactions = new ArrayList<>();
        this.balance = new BigDecimal("0");
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType.getDescription() +
                ", balance=" + balance +
                '}';
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void increaseBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void decreaseBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}
