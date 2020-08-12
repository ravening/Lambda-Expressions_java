package rv.factory;

public class VehicleDto {
    private String name;
    private VehicleColor vehicleColor;

    public VehicleDto(String name, VehicleColor vehicleColor) {
        this.name = name;
        this.vehicleColor = vehicleColor;
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
