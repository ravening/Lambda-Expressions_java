package rv.builder;

import java.util.stream.Stream;

public class StreamBuilder {
    public static void main(String[] args) {
        Stream<Object> stringBuilder = Stream.builder()
                .add("One")
                .add("two")
                .add("three").build();

        stringBuilder.forEach(System.out::println);
    }
}
