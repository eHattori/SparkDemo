package dependencyinjection;

import java.util.HashMap;
import java.util.Map;

public class Linker {

    private final Map<Class<?>, Factory<?>> factories = new HashMap<>();

    public <T> void install(Class<T> key,  Factory<T> factory){
        System.out.println("Add " + key);
        factories.put(key, factory);
    }

    public <T> Factory<T> factorFor(Class<T> key){
        System.out.println("Get factory for " + key);
        return (Factory<T>) factories.get(key);
    }

}