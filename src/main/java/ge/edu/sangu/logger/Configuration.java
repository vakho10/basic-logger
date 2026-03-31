package ge.edu.sangu.logger;

public class Configuration {
    public static final Configuration configuration = new Configuration();

    private Level loggingLevel = Level.INFO;
    private Formatter formatter = Formatter.DEFAULT;

    public Configuration() {
    }

    public Configuration(Level loggingLevel, Formatter formatter) {
        this.loggingLevel = loggingLevel;
        this.formatter = formatter;
    }

    public Level loggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(Level loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public Formatter formatter() {
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
