package dependencyinjection;

public final class ValueFactory<T> implements Factory<T> {

      @Override  public void link(Linker linker){
        
    }

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