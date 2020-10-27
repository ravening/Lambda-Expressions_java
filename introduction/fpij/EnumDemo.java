package fpij;

public class EnumDemo {
    public static void main(String[] args) {
        State state = State.Free;
        System.out.println(state.name().toLowerCase());
    }
}

enum State {
    Free,
    Allocated,
    Released
}