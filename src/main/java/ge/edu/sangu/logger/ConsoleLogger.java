package ge.edu.sangu.logger;

/**
 * ConsoleLogger is a concrete implementation of the Logger class that logs
 * messages to the system console. This class provides a direct mechanism for
 * writing log messages to the standard output stream using {@link System#out}.
 * <p>
 * The log messages are formatted using the inherited {@link Formatter} instance
 * from the parent Logger class and then printed to the console.
 */
public class ConsoleLogger extends Logger {
    public ConsoleLogger(String name) {
        super(name);
    }

    @Override
    protected void writeToOutput(String output) {
        System.out.print(output);
    }
}
