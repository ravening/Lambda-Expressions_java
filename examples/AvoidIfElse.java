import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class AvoidIfElse {
    private final Map<Predicate<Cart>, Function<Cart, Double>> rules;

    AvoidIfElse() {
        rules = new HashMap<>();
        rules.put(Predicates.WHEN_CART_VALUE_IS_SIX, Functions.MULTIPLY_WITH_ONE_POINT_FIVE);
        rules.put(Predicates.WHEN_CART_VALUE_IS_SEVEN, Functions.MULTIPLY_WITH_THREE_POINT_FIVE);
        rules.put(Predicates.WHEN_CART_VALUE_IS_GREATER_THAN_TEN, Functions.MULTIPLY_WITH_FIVE_POINT_FIVE);
    }

    public Function getRule(Cart cart) {
        return rules
                .entrySet()
                .stream()
                .filter(e -> e.getKey().test(cart))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(Functions.DEFAULT);
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.setValue(10);

        AvoidIfElse avoidIfElse = new AvoidIfElse();
        System.out.println("value is " + avoidIfElse.getRule(cart).apply(cart));
    }
}

class Predicates {
    public static final Predicate<Cart> WHEN_CART_VALUE_IS_SIX = cart -> cart.getValue() == 6;
    public static final Predicate<Cart> WHEN_CART_VALUE_IS_SEVEN = cart -> cart.getValue() == 7;
    public static final Predicate<Cart> WHEN_CART_VALUE_IS_GREATER_THAN_TEN = cart -> cart.getValue() >= 10;
}

class Functions {
    public static final Function<Cart, Double> MULTIPLY_WITH_ONE_POINT_FIVE = cart -> cart.getValue() * 1.5;
    public static final Function<Cart, Double> MULTIPLY_WITH_THREE_POINT_FIVE = cart -> cart.getValue() * 3.5;
    public static final Function<Cart, Double> MULTIPLY_WITH_FIVE_POINT_FIVE = cart -> cart.getValue() * 5.5;
    public static final Function<Cart, Double> DEFAULT = cart -> {return 1.0;};
}
class Cart {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
