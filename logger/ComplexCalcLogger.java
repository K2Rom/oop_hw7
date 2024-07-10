package logger;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import calculator.ComplexCalculator;

public class ComplexCalcLogger {

    private static Logger LOGGER;

    static {
        try (FileInputStream stream = new FileInputStream("./logger/log.config")) {
            LogManager.getLogManager().readConfiguration(stream);
            LOGGER = Logger.getLogger(ComplexCalculator.class.getName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        LOGGER.info(message);
    }

}
