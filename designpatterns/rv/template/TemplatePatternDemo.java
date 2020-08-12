package rv.template;

import rv.factory.Vehicle;
import rv.factory.VehicleColor;
import rv.factory.VehicleDto;
import rv.factory.VehicleType;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        VehicleDto vehicleDto = new VehicleDto("RNET", VehicleColor.RED);
        VehicleDto carDto = new VehicleDto("Uber", VehicleColor.BLACK);
        VehicleInterface bus = (VehicleInterface) VehicleType.BUS.getFunction().apply(vehicleDto);
        VehicleInterface uber = (VehicleInterface) VehicleType.CAR.getFunction().apply(carDto);

        bus.start(nil -> {
            System.out.println("Make sure that all passengers scan their card");
            System.out.println("Make sure all passengers are seated");
            System.out.println("Make sure doors are closed");
        });

        uber.start(nil -> {
            System.out.println("Make sure passenger provides otp");
            System.out.println("Make sure passenger has seat belt on");
            System.out.println("Make sure to star the trip");
        });
    }
}
