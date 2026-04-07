package ge.edu.sangu.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * Formatter is a utility class for constructing formatted log messages.
 * This class allows users to specify a format string that defines the structure
 * and content of log messages.
 * <p>
 * It provides functionality to replace
 * placeholders in the format string with actual values during message formatting.
 */
public class Formatter {
    public static final Formatter DEFAULT = new Formatter("[$date][$threadName][$loggingLevel][$name]: $m$n");

    private String format;

    public Formatter(String format) {
        this.format = format;
    }

    /**
     * Formats and return a log message
     *
     * @param name    logger name
     * @param level   logging level
     * @param message log message
     * @return formatted log message
     */
    public String format(String name, Level level, String message) {
        String output = format;
        if (output.contains("$threadName")) {
            output = output.replaceAll(Pattern.quote("$threadName"), Thread.currentThread().getName());
        }
        if (output.contains("$name")) {
            output = output.replaceAll(Pattern.quote("$name"), name);
        }
        if (output.contains("$n")) {
            output = output.replaceAll(Pattern.quote("$n"), "\n");
        }
        if (output.contains("$loggingLevel")) {
            output = output.replaceAll(Pattern.quote("$loggingLevel"), level.name());
        }
        if (output.contains("$date")) {
            output = output.replaceAll(Pattern.quote("$date"), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        }
        if (output.contains("$m")) {
            output = output.replaceAll(Pattern.quote("$m"), message);
        }
        return output;
    }
}
