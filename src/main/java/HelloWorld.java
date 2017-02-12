import static spark.Spark.*;

public class HelloWorld {

	public static void main(String[] args) {		
		
		get("/hello", (req, res) -> "\n\n Hello bandi loko \n\n\n");
	}
}
