package dependencyinjection;

import java.util.HashMap;
import java.util.Map;

public class Linker {

    private final Map<Class<?>, Factory<?>> factories = new HashMap<>();
    private final Map<Class<?>, Factory<?>> linkedFactories = new HashMap<>();

    public <T> void install(Class<T> key,  Factory<T> factory){        
        factories.put(key, factory);
    }

    public <T> Factory<T> factorFor(Class<T> key){

        System.out.println("Get factory for " + key);
        Factory<?> factory = linkedFactories.get(key);

        if(factory == null){
            System.out.println("Link factory for " + key);
            factory = factories.get(key);
            factory.link(this);
            linkedFactories.put(key, factory);
        }        
        return (Factory<T>) factories.get(key);
    }

}