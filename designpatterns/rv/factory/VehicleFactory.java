package rv.factory;

public class VehicleFactory {
    public static void main(String[] args) {
        VehicleDto vehicleDto = new VehicleDto("Mercedes", VehicleColor.SILVER);
        Vehicle redCar = VehicleType.CAR.getFunction().apply(vehicleDto);
        vehicleDto.setName("Volvo");
        vehicleDto.setVehicleColor(VehicleColor.BLACK);
        Vehicle blackVolvoTruck = VehicleType.TRUCK.getFunction().apply(vehicleDto);
        vehicleDto.setName("Yamaha");
        vehicleDto.setVehicleColor(VehicleColor.GREY);
        Vehicle greyScooter = VehicleType.SCOOTER.getFunction().apply(vehicleDto);
        vehicleDto.setName("VDL");
        vehicleDto.setVehicleColor(VehicleColor.BLUE);
        Vehicle blueBus = VehicleType.BUS.getFunction().apply(vehicleDto);
        System.out.println(redCar);
        System.out.println(blackVolvoTruck);
        System.out.println(greyScooter);
        System.out.println(blueBus);
    }
}
