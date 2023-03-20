package elf4j.impl.jpl;

import elf4j.impl.core.NativeLogger;
import lombok.Value;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 *
 */
@Value
public class Elf4jLogger implements System.Logger {
    private static final Class<?> SERVICE_INTERFACE_CLASS = System.Logger.class;
    String name;
    NativeLogger nativeLogger;

    private static elf4j.Level translate(Level level) {
        switch (level) {
            case INFO:
                return elf4j.Level.INFO;
            case ERROR:
                return elf4j.Level.ERROR;
            case DEBUG:
                return elf4j.Level.DEBUG;
            case TRACE:
            case ALL:
                return elf4j.Level.TRACE;
            case WARNING:
                return elf4j.Level.WARN;
            case OFF:
                return elf4j.Level.OFF;
            default:
                throw new IllegalArgumentException("Unexpected level: " + level);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isLoggable(Level level) {
        return this.nativeLogger.atLevel(translate(level)).isEnabled();
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        if (!isLoggable(level)) {
            return;
        }
        NativeLogger atLevel = this.nativeLogger.atLevel(translate(level));
        atLevel.getLogService()
                .log(atLevel, SERVICE_INTERFACE_CLASS, thrown, bundle == null ? msg : bundle.getString(msg), null);
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        if (!isLoggable(level)) {
            return;
        }
        String bundledFormat = bundle == null ? format : bundle.getString(format);
        MessageFormat bundledMessageFormat = bundle == null ? new MessageFormat(bundledFormat) :
                new MessageFormat(bundledFormat, bundle.getLocale());
        NativeLogger atLevel = this.nativeLogger.atLevel(translate(level));
        atLevel.getLogService().log(atLevel, SERVICE_INTERFACE_CLASS, null, bundledMessageFormat.format(params), null);
    }
}
