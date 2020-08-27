package rv.factory;

import java.awt.*;

public class PlayWithFactory {
    public static void main(String[] args) {
        Factory<Circle> factory = Factory.createFactory(Circle::new, Color.RED);
        Circle circle = factory.newInstance();
        System.out.println(circle);

        System.out.println("circles are " + factory.getRequiredCircles(5));
    }
}
