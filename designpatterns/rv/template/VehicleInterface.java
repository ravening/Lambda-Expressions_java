package rv.template;

import java.util.function.Consumer;

public interface VehicleInterface {
    default void start(Consumer<Void> preStartChecks) {
        preStartChecks.accept(null);
        System.out.println(String.format("%s starting...", this.getClass().getSimpleName()));
    }
}
