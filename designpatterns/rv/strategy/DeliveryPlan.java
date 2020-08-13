package rv.strategy;

import java.math.BigDecimal;
import java.util.function.Function;

public enum DeliveryPlan {
    BASIC(deliveryCost("0.50")),
    PREMIUM(deliveryCost("0.10")),
    BUSINESS(deliveryCost("0.0"))
    ;

    private final Function<Item, BigDecimal> function;

    public Function<Item, BigDecimal> getFunction() {
        return this.function;
    }
    private static Function<Item, BigDecimal> deliveryCost(String extraCost) {
        return item -> item.getPrice().multiply(new BigDecimal(extraCost)).add(new BigDecimal("1.0"));
    }

    DeliveryPlan(Function<Item, BigDecimal> function) {
        this.function = function;
    }
}
