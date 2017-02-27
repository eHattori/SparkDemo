package dependencyinjection;

public final class ValueFactory<T> extends Factory<T> {

    public static <T> Factory<T> of(T instance){
        return new ValueFactory<>(instance);
    }

    private final T value;

    private ValueFactory(T value){
        this.value = value;
    }

    @Override public T get(Linker linker){
        return value;
    }
}