package rv.factory;

import java.util.function.Consumer;

public class PlayWithRegistryBuilder {
    public static void main(String[] args) {
        Consumer<Builder<Rectangle>> consumer = builder ->
            builder.register("rectangle", Rectangle::new);
    }
}
