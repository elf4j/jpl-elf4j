# jpl-elf4j

An adapter to use [elf4j-engine](https://github.com/elf4j/elf4j-engine) as the runtime logging _service provider_ of the
Java 9 Platform Logging (System.Logger) API

## User Story

As an application developer using the Java Platform Logging (JPL) API introduced since Java 9, I want to opt to
use [elf4j-engine](https://github.com/elf4j/elf4j-engine) as the runtime logging _service provider_.

## Prerequisite

Java 9 or better

## Get It...

[![Maven Central](https://img.shields.io/maven-central/v/io.github.elf4j/jpl-elf4j.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.elf4j%22%20AND%20a:%22jpl-elf4j%22)

## User It...

Code against the Java 9 System.Logger API, and install this as a runtime-scope dependency e.g. with Maven:

```html
...
<dependency>
    <groupId>io.github.elf4j</groupId>
    <artifactId>jpl-elf4j</artifactId>
    <scope>runtime</scope>
</dependency>
...
```

The usual elf4j-engine [configuration](https://github.com/elf4j/elf4j-provider#configuration) applies.
