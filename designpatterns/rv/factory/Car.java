package rv.factory;

import rv.template.VehicleInterface;

public class Car extends Vehicle implements VehicleInterface {

    public Car(VehicleDto vehicleDto) {
        super(vehicleDto);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + this.getName() + '\'' +
                ", vehicleColor=" + this.getVehicleColor() +
                '}';
    }
}
