import java.io.*;
import dependencyinjection.*;

public class Application {

	public static void main(String[] args) {

		Counter counter = new Counter();
		PrintStream printStream = System.out;
		Logger logger = new Logger(printStream);

		VisitHandler visitiHandler = new VisitHandler(counter, logger);
		visitiHandler.visit();
		

	}
}
