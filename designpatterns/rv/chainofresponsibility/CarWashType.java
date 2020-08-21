package rv.chainofresponsibility;

import java.util.function.Function;

public enum CarWashType {
    FULL(CarWashSteps.fullCarWash()),
    REGULAR(CarWashSteps.regularCarWash()),
    WASH(CarWashSteps.onlyWash())
    ;

    private final Function<Car, Car> carFunction;

    CarWashType(Function<Car, Car> function) {
        this.carFunction = function;
    }

    public Function<Car, Car> getCarFunction() {
        return carFunction;
    }
}
