package dependencyinjection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;


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

    private <T> Factory<?> loadFactory(Class<T> key){

        Factory<?> factory = factories.get(key);
        if(factory != null){
            return factory;
        }

        Constructor<T> contructor = findAtInjectConstructor(key);

        if(contructor != null){
            factory = new ReflectiveFactory<>(contructor);
            
            if(key.isAnnotationPresent(Singleton.class)){
                factory = SingletonFactory.of(factory);
            }

            return factory;
        }

        throw new IllegalStateException("No factory for " + key);
    }


    private <T> Constructor<T> findAtInjectConstructor(Class<T> type){
        for(Constructor<?> constructor : type.getConstructors()){
            if(constructor.isAnnotationPresent(Inject.class)){
            	
                return (Constructor<T>) constructor;
            }
        }

        return null;
    }

}