package fpij;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumDemo {
    public static void main(String[] args) {
        State state = State.FREE;
        System.out.println(state.getName().toLowerCase());
        State state2 = State.get("FREE");
        System.out.println(state2.name());

        String test = "     hello world   ";
        System.out.println("Before modification: " + test);
        String modified = BasicStringOperation.TRIM.apply(test);
        System.out.println("Modification: " + modified);
    }
}

enum State {
    FREE("Free"), ALLOCATED("Allocated"), RELEASED("Released");

    private String name;

    private static final Map<String, State> stateMap;

    String getName() {
        return name;
    }

    State(String name) {
        this.name = name;
    }

    static {
        stateMap = Stream.of(values())
                .collect(Collectors.toMap(State::name, Function.identity()));
    }

    public static State get(String name) {
        if (!stateMap.containsKey(name)) {
            throw new IllegalArgumentException("No name found");
        }

        return stateMap.get(name);
    }
}

/**
 * StringOperation
 */
interface StringOperation {

    String getDescription();
    String apply(String value);
}

enum BasicStringOperation implements StringOperation {
    TRIM("Removing the leading and trailing whitespace characters") {
        @Override
        public String apply(String value) {
            return value.trim();
        }
    },
    TO_UPPER("Convert to upper case") {
        @Override
        public String apply(String value) {
            return value.toUpperCase();
        }
    },
    TO_LOWER("Convert to lower case") {
        @Override
        public String apply(String value) {
            return value.toLowerCase();
        }
    },
    REVERSE("Reverse the string") {
        @Override
        public String apply(String value) {
            return value.toString();
//            return value.reverse().toString();
        }
    }
    ;

    private String description;

    BasicStringOperation(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
