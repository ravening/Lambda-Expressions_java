package rv.strategy.search;

import java.util.List;

public class SearchAlgorithm {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> unsortedList = List.of(10, 1, 5, 4, 9, 2, 8, 7, 5, 3);
        int key = 3;
        SearchStrategy strategy = SearchStrategy.LINEAR;
        Integer position = strategy.getSearchFunction().apply(unsortedList, key);
        checkIfNumberExists(position);

        strategy = SearchStrategy.BINARY;
        position = strategy.getSearchFunction().apply(integers, 10);
        checkIfNumberExists(position);
    }

    public static void checkIfNumberExists(int position) {
        if (position != -1) {
            System.out.println("Key found at position " + position);
        } else {
            System.err.println("Element not found");
        }
    }
}
