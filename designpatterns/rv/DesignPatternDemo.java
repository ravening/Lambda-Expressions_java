package rv;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesignPatternDemo {
    public static void main(String[] args) {
        {
            Function<String, Predicate<String>> checkIfStartsWithLetter =
                    letter -> name -> name.startsWith(letter);

            List<String> persons = Arrays.asList("John", "Doe", "Johnny", "Dude", "Jonathon", "Donald", "Johnson");
            long countJ = persons.stream()
                    .filter(checkIfStartsWithLetter.apply("J"))
                    .count();

            long countD = persons.stream()
                    .filter(checkIfStartsWithLetter.apply("D"))
                    .count();

            System.out.println("Persons starting with J " + countJ);
            System.out.println("Persons starting with D " + countD);
        }
    }


}
