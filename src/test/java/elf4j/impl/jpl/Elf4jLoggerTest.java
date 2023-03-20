package elf4j.impl.jpl;

import org.junit.jupiter.api.Test;

class Elf4jLoggerTest {
    System.Logger logger = System.getLogger(Elf4jLoggerTest.class.getName());

    @Test
    void logs() {
        logger.log(System.Logger.Level.INFO, "Hello, world!");
        logger.log(System.Logger.Level.INFO, () -> "This message comes from a Supplier");
        logger.log(System.Logger.Level.INFO, "Parameterized message with args {0} and {1}", "ONE", "TWO");
        logger.log(System.Logger.Level.ERROR, "Houston, we have a problem!", new Exception("Houston exception"));
    }
}