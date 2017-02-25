package dependencyinjection;

import dependencyinjection.*;

public interface Factory<T>{
    T get(Linker linker);
}