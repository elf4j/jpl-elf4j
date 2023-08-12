package elf4j.engine.jpl;

import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.ResourceBundle;

class Elf4jLoggerTest {
    System.Logger logger = System.getLogger(Elf4jLoggerTest.class.getName());

    @Test
    void logs() {
        logger.log(System.Logger.Level.INFO, "Hello, world!");
        logger.log(System.Logger.Level.INFO, () -> "This message comes from a Supplier");
        logger.log(System.Logger.Level.INFO, "Parameterized message with args {0} and {1}", "ONE", "TWO");
        logger.log(System.Logger.Level.ERROR, "Houston, we have a problem!", new Exception("Houston exception"));
        logger.log(System.Logger.Level.INFO, new ResourceBundle() {
            @Override
            protected Object handleGetObject(@NonNull String key) {
                return key;
            }

            @Override
            public Enumeration<String> getKeys() {
                throw new UnsupportedOperationException();
            }
        }, "Localized message with args {0} and {1}", "FOO", "BAR");
    }
}
