package elf4j.engine.jpl;

import elf4j.engine.NativeLogger;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import lombok.Value;

/**
 *
 */
@Value
public class Elf4jLogger implements System.Logger {
    private static final Class<?> SERVICE_INTERFACE_CLASS = Elf4jLogger.class;
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
    public void log(Level level, String msg) {
        service(level, null, null, msg);
    }

    @Override
    public void log(Level level, Supplier<String> msgSupplier) {
        service(level, null, null, Objects.requireNonNull(msgSupplier).get());
    }

    @Override
    public void log(Level level, Object obj) {
        service(level, null, null, Objects.toString(Objects.requireNonNull(obj)));
    }

    @Override
    public void log(Level level, String msg, Throwable thrown) {
        service(level, null, thrown, msg);
    }

    @Override
    public void log(Level level, Supplier<String> msgSupplier, Throwable thrown) {
        service(level, null, thrown, Objects.requireNonNull(msgSupplier).get());
    }

    @Override
    public void log(Level level, String format, Object... params) {
        service(level, null, null, format, params);
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        service(level, bundle, thrown, msg);
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        service(level, bundle, null, format, params);
    }

    private void service(Level level, ResourceBundle bundle, Throwable thrown, String message, Object... params) {
        NativeLogger delegateLogger = nativeLogger.atLevel(translate(level));
        if (!delegateLogger.isEnabled()) {
            return;
        }
        String format = bundle == null ? message : bundle.getString(message);
        if (params == null || params.length == 0) {
            delegateLogger.getLogService().log(delegateLogger, SERVICE_INTERFACE_CLASS, thrown, format, null);
            return;
        }
        MessageFormat messageFormat =
                bundle == null ? new MessageFormat(format) : new MessageFormat(format, bundle.getLocale());
        delegateLogger
                .getLogService()
                .log(delegateLogger, SERVICE_INTERFACE_CLASS, thrown, messageFormat.format(params), null);
    }
}
