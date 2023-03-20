# jpl-elf4j

ELF4J logging engine provider of the Java 9 platform logging API

## User Story

As an application developer using the Java 9 System Logger API, I want to opt to use
the [elf4j-impl-core](https://github.com/elf4j/elf4j-impl-core) as the runtime logging engine.

## Prerequisite

Java 9 or better

## Get it...

[![Maven Central](https://img.shields.io/maven-central/v/io.github.elf4j/jpl-elf4j.svg?label=Maven%20Central)](https://central.sonatype.com/search?smo=true&q=pkg%253Amaven%252Fio.github.elf4j%252Fjpl-elf4j)

Install as a runtime-scope dependency e.g. with Maven:

```html
...
<dependency>
    <groupId>io.github.elf4j</groupId>
    <artifactId>jpl-elf4j</artifactId>
    <scope>runtime</scope>
</dependency>
...
```

The regular elf4j-impl-core [configuration](https://github.com/elf4j/elf4j-impl#configuration) applies, as usual.