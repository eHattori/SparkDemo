package dependencyinjection;

import java.io.PrintStream;

public class Logger {

    private final PrintStream printStream;

    public Logger(PrintStream printStream){
        this.printStream = printStream;
    }

    public void log(String log){
        printStream.println(log);
    }
}