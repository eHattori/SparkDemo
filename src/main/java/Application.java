import dependencyinjection.*;

public class Application {

	public static void main(String[] args) {

		ObjectGraph objectGraph =  ObjectGraph.buildObjectGraph();
		VisitHandler visitiHandler = objectGraph.get(VisitHandler.class);
		visitiHandler.visit();
		

	}
}
