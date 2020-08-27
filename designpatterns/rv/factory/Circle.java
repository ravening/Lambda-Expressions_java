package rv.factory;

import java.awt.*;

public class Circle {
    private final Color color;

    Circle(Color color) {
        this.color = color;
    }

    Circle() {
        this.color = Color.WHITE;
    }
    @Override
    public String toString() {
        return "Circle{color = " + this.color + "}";
    }
}
