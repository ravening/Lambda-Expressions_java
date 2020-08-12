package rv.factory;

import rv.template.VehicleInterface;

public class Scooter extends Vehicle implements VehicleInterface {
    public Scooter(VehicleDto vehicleDto) {
        super(vehicleDto);
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "name='" + this.getName() + '\'' +
                ", vehicleColor=" + this.getVehicleColor() +
                '}';
    }
}
