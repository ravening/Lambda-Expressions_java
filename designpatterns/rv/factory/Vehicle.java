package rv.factory;

public class Vehicle {
    private String name;
    private VehicleColor vehicleColor;

    public Vehicle(String name, VehicleColor vehicleColor) {
        this.name = name;
        this.vehicleColor = vehicleColor;
    }

    public Vehicle(VehicleDto vehicleDto) {
        this.name = vehicleDto.getName();
        this.vehicleColor = vehicleDto.getVehicleColor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleColor getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(VehicleColor vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
}
