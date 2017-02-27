package dependencyinjection;

public abstract class Factory<T>{

    protected void link(Linker link){
        
    }

    public abstract T get(Linker linker);

    
}