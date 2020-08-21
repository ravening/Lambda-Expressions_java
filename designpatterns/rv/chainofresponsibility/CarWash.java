package rv.chainofresponsibility;

public class CarWash {
    public static void main(String[] args) {
        Car car = new Car();
        CarWashType.REGULAR.getCarFunction().apply(car);
        System.out.println("==========");
        CarWashType.FULL.getCarFunction().apply(car);
    }
}
