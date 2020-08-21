package rv.chainofresponsibility;

public class Car {
    private WashState washState;

    public Car() {
        System.out.println("Initial car state is " + WashState.INITIAL);
    }

    public Car setWashState(WashState state) {
        this.washState = state;
        System.out.println("Car state transitioned to " + this.washState);
        return this;
    }

    public WashState getWashState() {
        return this.washState;
    }
}
