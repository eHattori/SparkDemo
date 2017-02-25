package dependencyinjection;

import java.util.HashMap;
import java.util.Map;

public class Linker {

    private final Map<Class<?>, Factory<?>> factories = new HashMap<>();

    public <T> void install(Class<T> key,  Factory<T> factory){
        factories.put(key, factory);
    }

    public <T> Factory<T> factorFor(Class<T> key){
        return (Factory<T>) factories.get(key);
    }

}