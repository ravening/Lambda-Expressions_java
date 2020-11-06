package rv.chainofresponsibility.atm;

import java.math.BigDecimal;
import java.util.function.Function;

public class MoneyDispenser {
    private final Currency currency;

    MoneyDispenser(Currency c) {
        this.currency = c;
    }

    Currency validateCurrency(Currency c) {
        if (c == null)
            return null;

        return (c.getAmount().compareTo(new BigDecimal("0"))) > 0 ? c : null;
    }

    Function<Currency, Currency> hunderdsDispenser = c -> {
        return getValue(c, new BigDecimal("100.00"));
    };

    Function<Currency, Currency> fiftyDispenser = c -> {
        return getValue(c, new BigDecimal("50.00"));
    };

    Function<Currency, Currency> twentyDispenser = c -> {
        return getValue(c, new BigDecimal("20.00"));
    };

    Function<Currency, Currency> tenDispenser = c -> {
        return getValue(c, new BigDecimal("10.00"));
    };

    Currency getValue(Currency c, BigDecimal denomination) {
        if (c != null) {
            BigDecimal amount = c.getAmount();
            BigDecimal remainder = amount;

            if (amount.compareTo(denomination) >= 0) {
                BigDecimal count = amount.divideToIntegralValue(denomination);
                remainder = amount.remainder(denomination);
                System.out.println("Dispatching " + count + " €" + denomination + " notes");
            }
            c = c.setAmount(remainder);
        }
        return validateCurrency(c);
    }

    Function<Currency, Currency> dispatcher = hunderdsDispenser
            .andThen(fiftyDispenser)
            .andThen(twentyDispenser)
            .andThen(tenDispenser);

    void dispatch() {
        if (currency.getAmount().compareTo(new BigDecimal("10.00")) < 0) {
            System.out.println("Please enter amount greater than or equal to €10");
        }
        dispatcher.apply(currency);
    }
}
