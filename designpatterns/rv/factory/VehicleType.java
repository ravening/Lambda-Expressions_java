package rv.factory;

import java.util.function.Function;

public enum VehicleType {
    CAR(Car::new),
    BUS(Bus::new),
    TRUCK(Truck::new),
    SCOOTER(Scooter::new)
    ;

    private final Function<VehicleDto, Vehicle> function;

    VehicleType(Function<VehicleDto, Vehicle> function) {
        this.function = function;
    }

    public Function<VehicleDto, Vehicle> getFunction() {
        return this.function;
    }
}
