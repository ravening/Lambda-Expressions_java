package rv.factory;

import java.math.BigDecimal;

public class Vehicle {
    private String name;
    private VehicleColor vehicleColor;
    private BigDecimal washPrice;

    public Vehicle(String name, VehicleColor vehicleColor) {
        this.name = name;
        this.vehicleColor = vehicleColor;
    }

    public Vehicle(VehicleDto vehicleDto) {
        this.name = vehicleDto.getName();
        this.vehicleColor = vehicleDto.getVehicleColor();
    }

    public Vehicle(String name, VehicleColor vehicleColor, BigDecimal washPrice) {
        this.name = name;
        this.vehicleColor = vehicleColor;
        this.washPrice = washPrice;
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

    public BigDecimal getWashPrice() {
        return washPrice;
    }

    public void setWashPrice(BigDecimal washPrice) {
        this.washPrice = washPrice;
    }
}
