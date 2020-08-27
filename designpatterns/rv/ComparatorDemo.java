package rv;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparatorDemo {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));
        Map<Integer, List<String>> nameOfPeople =
                people.stream()
                        .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));

        Comparator<Person> cmpName = comparing(Person::getName);
        Comparator<Person> cmpAge = comparing(Person::getAge);

        Comparator<Person> nameAgeComparator = cmpName.thenComparing(cmpAge);
        Comparator<Person> ageNameComparator = cmpAge.thenComparing(cmpName);
        System.out.println("Sara is same age as Jane? " + (cmpAge.compare(people.get(1), people.get(2)) == 0));
        System.out.println("John is younger than Sara? " + (cmpAge.compare(people.get(0), people.get(1)) < 0));
        System.out.println("Sara is elder than Greg? " + (cmpAge.compare(people.get(1), people.get(3)) > 0));

        System.out.println("Sorting people based on their names and then age");
        List<Person> sortedPeople = people
                .stream()
                .sorted(nameAgeComparator)
                .collect(Collectors.toList());
        System.out.println(sortedPeople);

        System.out.println("Sorting people based on their age and then name");
        sortedPeople = people.stream()
                .sorted(ageNameComparator)
                .collect(Collectors.toList());
        System.out.println(sortedPeople);
    }

    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<T, U> function) {
        Objects.requireNonNull(function);
        return (p1, p2) -> {
            U name1 = function.apply(p1);
            U name2 = function.apply(p2);
            return name1.compareTo(name2);
        };
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int ageDifference(Person other) {
        return this.age - other.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
