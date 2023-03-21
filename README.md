# jpl-elf4j

An adapter to use [elf4j-engine](https://github.com/elf4j/elf4j-engine) as the runtime logging _service provider_ of the
Java 9 Platform Logging (System.Logger) API

## User Story

As an application developer using the Java Platform Logging (JPL) API introduced since Java 9, I want to opt to
use [elf4j-engine](https://github.com/elf4j/elf4j-engine) as the runtime logging _service provider_.

## Prerequisite

Java 9 or better

## Get it...

[![Maven Central](https://img.shields.io/maven-central/v/io.github.elf4j/jpl-elf4j.svg?label=Maven%20Central)](https://central.sonatype.com/search?smo=true&q=pkg%253Amaven%252Fio.github.elf4j%252Fjpl-elf4j)

Code against the Java 9 System.Logger API. Install this as a runtime-scope dependency e.g. with Maven:

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
