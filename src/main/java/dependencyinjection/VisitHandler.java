package dependencyinjection;

public class VisitHandler {

    private final Counter counter;
    private final Logger logger;

    @Inject public VisitHandler(Counter counter, Logger logger){
        this.counter = counter;
        this.logger = logger;
    }

    public void visit(){
        counter.increment();
        logger.log("Visit increased " + counter.getCount());
    }


}