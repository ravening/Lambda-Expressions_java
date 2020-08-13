package rv.strategy;

import rv.factory.Vehicle;
import rv.factory.VehicleColor;

import java.math.BigDecimal;

public class StrategyDemo {
    public static void main(String[] args) {
        Item item = new Item("TV", new BigDecimal("1000"));
        BigDecimal price = DeliveryPlan.BASIC.getFunction().apply(item);
        System.out.println("Cost of delivering tv in basic package is " + price);
        price = DeliveryPlan.PREMIUM.getFunction().apply(item);
        System.out.println("Cost of delivering tv in premium package is " + price);
        price = DeliveryPlan.BUSINESS.getFunction().apply(item);
        System.out.println("Cost of delivering tv in business package is " + price);

        Vehicle car = new Vehicle("Ferrari", VehicleColor.RED, new BigDecimal("150"));
        Vehicle bus = new Vehicle("Mercedes", VehicleColor.BLACK, new BigDecimal("550"));
        Vehicle truck = new Vehicle("Volvo", VehicleColor.GREY, new BigDecimal("660"));
        Vehicle scooter = new Vehicle("Yamaha", VehicleColor.BLUE, new BigDecimal("100"));
        System.out.println("Price for washing car is " + VehicleWash.CAR.getFunction().apply(car));
        System.out.println("Price for washing bus is " + VehicleWash.CAR.getFunction().apply(bus));
        System.out.println("Price for washing truck is " + VehicleWash.CAR.getFunction().apply(truck));
        System.out.println("Price for washing scooter is " + VehicleWash.CAR.getFunction().apply(scooter));
    }
}
