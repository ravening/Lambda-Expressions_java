package rv.strategy.search;

import java.util.List;
import java.util.function.BiFunction;

public enum SearchStrategy {
    LINEAR(linearSearchFunction()),
    BINARY(binarySearchFunction())
    ;

    private final BiFunction<List<Integer>, Integer, Integer> searchFunction;

    SearchStrategy(BiFunction<List<Integer>, Integer, Integer> function) {
        this.searchFunction = function;
    }

    private static BiFunction<List<Integer>, Integer, Integer> linearSearchFunction() {
        return (list, key) -> {
            int index = -1;
            int i = 0;

            if (list.size() == 0)
                return -1;

            while (i < list.size() && index == -1) {
                if (list.get(i) == key) {
                    index = i;
                }
                i++;
            }
            return index;
        };
    }

    private static BiFunction<List<Integer>, Integer, Integer> binarySearchFunction() {
        return ((list, integer) -> {
            if (list.isEmpty())
                return -1;

            int index = -1;
            int low = 0;
            int high = list.size() - 1;

            while (low <= high && index == -1) {
                int middle = (low + high) / 2;
                Integer tmp = list.get(middle);
                if (tmp.compareTo(integer) < 0) {
                    low = middle + 1;
                } else if (tmp.compareTo(integer) > 0) {
                    high = middle - 1;
                } else {
                    index = middle;
                }
            }
            return index;
        });
    }

    public BiFunction<List<Integer>, Integer, Integer> getSearchFunction() {
        return searchFunction;
    }
}
