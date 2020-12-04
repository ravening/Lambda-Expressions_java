package rv.chainofresponsibility.atm;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private BigDecimal amount;

    private Date timestamp;

    private String memo;

    private Account inAccount;

    private Account outAccount;

    public Transaction(BigDecimal amount, String memo) {
        this.amount = amount;
        this.timestamp = new Date();
        this.memo = memo;
    }

    public Transaction(BigDecimal amount, String memo, Account inAccount) {
        this(amount, memo);
        this.inAccount = inAccount;
    }

    public Transaction(BigDecimal amount, String memo, Account inAccount, Account outAccount) {
        this(amount, memo);
        this.inAccount = inAccount;
        this.outAccount = outAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", timestamp=" + timestamp +
                ", memo='" + memo + '\'' +
                ", inAccount=" + inAccount +
                ", outAccount=" + outAccount +
                '}';
    }
}
