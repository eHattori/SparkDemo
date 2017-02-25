package dependencyinjection;
import dependencyinjection.*;


public class ObjectGraph {

    private final Linker linker;

    public ObjectGraph(Linker linker){
        this.linker = linker;
    }
    
   public<T> T get(Class<T> key) {
		Factory<T> factory = linker.factorFor(key);
		return factory.get(linker);
	}
}