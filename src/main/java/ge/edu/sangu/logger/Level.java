package ge.edu.sangu.logger;

/**
 * Represents the severity levels for log messages.
 * The levels define the importance and priority of a log message.
 * These levels are typically used to classify and filter log outputs.
 * <p>
 * The available levels are:
 * <ul>
 * <li>TRACER: The lowest level, typically used for detailed debugging information.</li>
 * <li>DEBUG: Used for general debugging messages.</li>
 * <li>INFO: Standard messages to indicate the progress or state of the application.</li>
 * <li>WARN: Indicates potentially harmful situations that should be addressed.</li>
 * <li>ERROR: Signifies error events that might disrupt the application's normal flow.</li>
 * </ul>
 */
public enum Level {
    TRACER, DEBUG, INFO, WARN, ERROR
}
