package dependencyinjection;

public interface Factory<T>{

    public void link(Linker link);

    public abstract T get(Linker linker);

    
}