package rv.factory;

public enum VehicleColor {
    RED("Red"),
    BLUE("Blue"),
    SILVER("Silver"),
    GREY("Grey"),
    BLACK("Black"),
    WHITE("WHITE")
    ;

    private final String color;

    VehicleColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
}
