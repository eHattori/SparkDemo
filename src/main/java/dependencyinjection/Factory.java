package dependencyinjection;

public interface Factory<T>{
    T get(Linker linker);
}