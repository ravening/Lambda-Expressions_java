package rv.factory;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {
    default T newInstance() {
        return get();
    }

    default List<T> getRequiredCircles(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    }

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <P, R> Factory<R> createFactory(Function<P, R> function, P color) {
        return () -> function.apply(color);
    }
}
