package ge.edu.sangu.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Formatter {
    public static final Formatter DEFAULT = new Formatter("[$date][$threadName][$loggingLevel][$name]: $m$n");

    private String format;

    public Formatter(String format) {
        this.format = format;
    }

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
