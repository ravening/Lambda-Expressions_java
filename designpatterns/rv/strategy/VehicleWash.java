package rv.strategy;

import rv.factory.Vehicle;

import java.math.BigDecimal;
import java.util.function.Function;

public enum VehicleWash {
    CAR(vehicleWash()),
    BUS(vehicleWash()),
    TRUCK(vehicleWash()),
    SCOOTER(vehicleWash())
    ;

    private final Function<Vehicle, BigDecimal> function;

    public Function<Vehicle, BigDecimal> getFunction() {
        return function;
    }

    public static Function<Vehicle, BigDecimal> vehicleWash() {
        return Vehicle::getWashPrice;
    }

    VehicleWash(Function<Vehicle, BigDecimal> function) {
        this.function = function;
    }
}
