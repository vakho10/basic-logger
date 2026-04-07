package ge.edu.sangu.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * FileLogger is a concrete implementation of the Logger class responsible for logging
 * messages to a specified file. This class provides functionality for persistent logging
 * by appending log entries to a file located at a given file path.
 * <p>
 * Each log message is formatted using the {@link Formatter} inherited from the Logger class
 * before being written to the file. If the file does not exist, it will be created. If an
 * error occurs while writing to the file, a {@link RuntimeException} is thrown.
 */
public class FileLogger extends Logger {

    private final String filePath;

    public FileLogger(String name, String filePath) {
        super(name);
        this.filePath = filePath;
    }

    @Override
    protected void writeToOutput(String output) {
        try {
            Files.writeString(Path.of(filePath), output, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
