package utils;
 
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Level;
 
public class LoggerHandler {
 
    private static final Logger logger = Logger.getLogger(LoggerHandler.class);
 
    static {
        setupLoggers();
    }
 
   
    private static void setupLoggers() {
        try {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String logFileName = String.format("logs/logfile_%s.log", timestamp);
           
 
            PatternLayout layout = new PatternLayout("%d{ISO8601} %-5p %c - %m%n");
            FileAppender timestampedAppender = createFileAppender(logFileName, layout);
           
 
            logger.addAppender(timestampedAppender);
           
 
        } catch (Exception e) {
            logger.error("Failed to initialize logger file appender", e);
        }
    }
 
    /**
     * @Description Creates a file appender with the specified file name and layout.
     * @param fileName The name of the file for logging.
     * @param layout The pattern layout for formatting log messages.
     * @return A configured FileAppender instance.
     * @throws Exception If an error occurs during appender creation.
     */
    private static FileAppender createFileAppender(String fileName, PatternLayout layout) throws Exception {
        return new FileAppender(layout, fileName, true);
    }
 
 
    public static void traceMessage(String message) {
        logger.trace(message);
    }
 
    public static void debugMessage(String message) {
        logger.debug(message);
    }
 
    public static void infoMessage(String message) {
        logger.info(message);
    }
 
    public static void warnMessage(String message) {
        logger.warn(message);
    }
 
    public static void errorMessage(String message) {
        logger.error(message);
    }
 
    public static void fatalMessage(String message) {
        logger.fatal(message);
    }
 
 
}