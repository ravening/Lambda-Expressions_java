package rv.chainofresponsibility;

import java.util.function.Function;
import java.util.stream.Stream;

public class CarWashSteps {
    private Function<Car, Car> washFunction;

    public Function<Car, Car> initCar = car -> {
        car.setWashState(WashState.INITIAL);
        return car;
    };

    public Function<Car, Car> washCar = car -> {
        car.setWashState(WashState.WASH);
        return car;
    };

    @SafeVarargs
    public final void setWashFunction(Function<Car, Car>... washFunctions) {
        washFunction = Stream.of(washFunctions)
                .reduce(Function::andThen)
                .orElseGet(Function::identity);
    }

    public void startWash(Car car) {
        this.washFunction.apply(car);
    }

    public static Function<Car, Car> fullCarWash() {
        Function<Car, Car> initialChain = c -> c;
        return initialChain
                .andThen(r -> r.setWashState(WashState.RINSE))
                .andThen(s -> s.setWashState(WashState.SOAP))
                .andThen(w -> w.setWashState(WashState.WASH))
                .andThen(d -> d.setWashState(WashState.DRY))
                .andThen(p -> p.setWashState(WashState.POLISH))
                .andThen(v -> v.setWashState(WashState.VACUUM))
                .andThen(r -> r.setWashState(WashState.READY));
    }

    public static Function<Car, Car> regularCarWash() {
        Function<Car, Car> initialChain = c -> c;
        return initialChain
                .andThen(r -> r.setWashState(WashState.RINSE))
                .andThen(w -> w.setWashState(WashState.WASH))
                .andThen(d -> d.setWashState(WashState.DRY))
                .andThen(v -> v.setWashState(WashState.VACUUM))
                .andThen(r -> r.setWashState(WashState.READY));
    }

    public static Function<Car, Car> onlyWash() {
        Function<Car, Car> initialChain = c -> c;
        return initialChain
                .andThen(r -> r.setWashState(WashState.RINSE))
                .andThen(w -> w.setWashState(WashState.WASH))
                .andThen(r -> r.setWashState(WashState.READY));
    }
}
