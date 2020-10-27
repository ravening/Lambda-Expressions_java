package rv.factory;

public interface Builder<T> {
    void register(String shape, Factory<T> factory);
}
