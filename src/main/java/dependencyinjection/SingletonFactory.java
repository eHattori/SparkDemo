package dependencyinjection;

public class SingletonFactory<T> implements Factory<T> {

     @Override  public void link(Linker linker){
        
    }

    public static <T> Factory<T> of(Factory<T> factory){
        return new SingletonFactory<>(factory);
    }

    private final Factory<T> factory;
    private T instance;

    private SingletonFactory(Factory<T> factory){
        this.factory = factory;
    }

    @Override
    public final T get(Linker linker){
        if(instance == null){
            instance = factory.get(linker);
        }
        return instance;
    }

}