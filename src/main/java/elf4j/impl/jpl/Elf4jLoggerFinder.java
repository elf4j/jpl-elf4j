package elf4j.impl.jpl;

import elf4j.impl.core.NativeLoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Elf4jLoggerFinder extends System.LoggerFinder {
    private final NativeLoggerFactory nativeLoggerFactory;
    private final Map<String, Elf4jLogger> elf4jLoggers = new HashMap<>();

    /**
     * Default constructor required by {@link java.util.ServiceLoader}
     */
    public Elf4jLoggerFinder() {
        this(new NativeLoggerFactory(System.class));
    }

    Elf4jLoggerFinder(NativeLoggerFactory nativeLoggerFactory) {
        this.nativeLoggerFactory = nativeLoggerFactory;
    }

    @Override
    public System.Logger getLogger(String name, Module module) {
        return elf4jLoggers.computeIfAbsent(name, k -> new Elf4jLogger(k, nativeLoggerFactory.logger()));
    }
}
