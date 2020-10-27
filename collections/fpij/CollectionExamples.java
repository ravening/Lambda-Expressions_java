import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionExamples {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        // get count of numbers less than 8
        long count = numbers.stream().filter(n -> n < 8).count();
        System.out.println(count);

        // get minimum value
        Optional<Integer> min = numbers.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(min.isPresent() ? min.get() : "0");

        // get the maximum value
        long max = numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
        System.out.println(max);

        // separat odd and even numbers
        Map<Boolean, List<Integer>> result = numbers.stream()
                                    .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(result);

        // sum of all numbers
        Integer sum = numbers.stream().collect(Collectors.summingInt(x -> x));
        System.out.println(sum);
        
    }
}
