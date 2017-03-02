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

    //    linker.install(VisitHandler.class, new Factory<VisitHandler>(){

    //        Factory<Counter> counterFactory ;
    //        Factory<Logger> loggerFactory;

    //        @Override
    //        public void link(Linker linker){
    //             counterFactory = linker.factorFor(Counter.class);
    //             loggerFactory = linker.factorFor(Logger.class);
    //        }

    //        @Override
    //        public VisitHandler get(Linker linker){

    //             Counter counter = counterFactory.get(linker);
    //             Logger logger = loggerFactory.get(linker);

    //             return new VisitHandler(counter, logger);
    //        }
    //    });
       
	    // linker.install(Logger.class, new Factory<Logger>() {

        //     Factory<PrintStream> printStreamFactory;

        //    @Override
        //    public void link(Linker linker){
        //        printStreamFactory = linker.factorFor(PrintStream.class);
        //    }

        //     @Override public Logger get(Linker linker) {               
        //             return new Logger(printStreamFactory.get(linker));
        //         }
    	// });
    	
  	    linker.install(PrintStream.class, ValueFactory.of (System.out));

        // linker.install(Counter.class, SingletonFactory.of (new Factory<Counter>(){

        //       @Override public Counter get(Linker linker) {
        //         return new Counter();   
        //       }
        //   }));
    }
}