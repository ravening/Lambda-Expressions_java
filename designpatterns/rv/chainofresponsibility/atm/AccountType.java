package rv.chainofresponsibility.atm;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AccountType {
    CHECKING("Checking"),
    SAVINGS("Savings")
    ;

    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description.toLowerCase();
    }

    private static final Map<String, AccountType> accountTypes;

    static {
        accountTypes = Stream.of(values())
                .collect(Collectors.toUnmodifiableMap(AccountType::getDescription, Function.identity()));
    }

    public static AccountType getAccountType(String type) {
        return accountTypes.getOrDefault(type.toLowerCase(), AccountType.SAVINGS);
    }
}
