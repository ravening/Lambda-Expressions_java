package rv.factory;

import rv.template.VehicleInterface;

public class Truck extends Vehicle implements VehicleInterface {
    public Truck(VehicleDto vehicleDto) {
        super(vehicleDto);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "name='" + this.getName() + '\'' +
                ", vehicleColor=" + this.getVehicleColor() +
                '}';
    }
}
