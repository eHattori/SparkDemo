package dependencyinjection;

import java.io.PrintStream;

public class ObjectGraph {

    private final Linker linker;

    public ObjectGraph(Linker linker){
        this.linker = linker;
    }
    
   public <T> T get(Class<T> key) {
		Factory<T> factory = linker.factorFor(key);
		return factory.get(linker);
	}

    public static ObjectGraph buildObjectGraph(){

        Linker linker = new Linker();
        installFactories(linker);
        return new ObjectGraph(linker);
    }

    private static void installFactories(Linker linker){

       linker.install(VisitHandler.class, new Factory<VisitHandler>(){

           @Override
           public VisitHandler get(Linker linker){

                Factory<Counter> counterFactory = linker.factorFor(Counter.class);
                Factory<Logger> loggerFactory = linker.factorFor(Logger.class);

                Counter counter = counterFactory.get(linker);
                Logger logger = loggerFactory.get(linker);

                return new VisitHandler(counter, logger);
           }
       });
       
	    linker.install(Logger.class, new Factory<Logger>() {
            @Override public Logger get(Linker linker) {
                Factory<PrintStream> printStreamFactory = linker.factorFor(PrintStream.class);
                    return new Logger(printStreamFactory.get(linker));
                }
    	});

    	linker.install(PrintStream.class, new Factory<PrintStream>() {
                @Override public PrintStream get(Linker linker) {
                    return System.out;
                }
    	});

  	    linker.install(PrintStream.class, ValueFactory.of (System.out));

        linker.install(Counter.class, SingletonFactory.of (new Factory<Counter>(){
              @Override public Counter get(Linker linker) {
                return new Counter();   
              }
          }));
    }
}