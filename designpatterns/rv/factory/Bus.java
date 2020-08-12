package rv.factory;

import rv.template.VehicleInterface;

public class Bus extends Vehicle implements VehicleInterface {
    public Bus(VehicleDto vehicleDto) {
        super(vehicleDto);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + this.getName() + '\'' +
                ", vehicleColor=" + this.getVehicleColor() +
                '}';
    }
}
