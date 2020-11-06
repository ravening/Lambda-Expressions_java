package rv.chainofresponsibility.atm;

import java.math.BigDecimal;

public class Currency {
    private BigDecimal amount;

    public Currency(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
}
