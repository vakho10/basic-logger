package ge.edu.sangu.logger;

import org.jetbrains.annotations.NotNull;

import static ge.edu.sangu.logger.Configuration.configuration;

/**
 * The Logger class serves as an abstract base for various types of loggers.
 * It provides a framework for formatting and logging messages at different
 * levels of severity and delegates the actual output mechanism to subclasses.
 *
 * @author v.laluashvili
 */
public abstract class Logger {

    private final String name;
    private final Formatter formatter;

    public Logger(String name) {
        this(name, configuration.formatter());
    }

    public Logger(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public String getName() {
        return name;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public void trace(String message, Object... args) {
        print(Level.TRACER, message, args);
    }

    public void debug(String message, Object... args) {
        print(Level.DEBUG, message, args);
    }

    public void info(String message, Object... args) {
        print(Level.INFO, message, args);
    }

    public void warn(String message, Object... args) {
        print(Level.WARN, message, args);
    }

    public void error(String message, Object... args) {
        print(Level.ERROR, message, args);
    }

    /**
     * Writes a formatted log message to the designated output if the provided logging
     * level is equal to or greater than the configured logging level.
     *
     * @param level   the logging level for the message; determines whether the message will be logged
     * @param message the log message to be formatted and printed; cannot be null or blank
     * @param args    additional arguments to be substituted into the formatted log message
     * @throws IllegalArgumentException if the provided message is null or blank
     */
    protected synchronized void print(@NotNull Level level, String message, @NotNull Object... args)
            throws IllegalArgumentException {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or blank");
        }
        if (configuration.loggingLevel().ordinal() <= level.ordinal()) {
            writeToOutput(
                    String.format(formatter.format(name, level, message), args)
            );
        }
    }

    /**
     * Outputs a constructed log message into an arbitrary output stream.
     *
     * @param output output string
     */
    protected abstract void writeToOutput(String output);
}
