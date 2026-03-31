package ge.edu.sangu.logger;

public class Configuration {
    private static Configuration INSTANCE;

    public synchronized static Configuration getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuration();
        }
        return INSTANCE;
    }

    private Level loggingLevel = Level.INFO;
    private Formatter formatter = Formatter.DEFAULT;

    public Configuration() {
    }

    public Configuration(Level loggingLevel, Formatter formatter) {
        this.loggingLevel = loggingLevel;
        this.formatter = formatter;
    }

    public Level getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(Level loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "loggingLevel=" + loggingLevel +
                ", formatter=" + formatter +
                '}';
    }
}
