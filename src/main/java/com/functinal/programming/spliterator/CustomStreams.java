package com.functinal.programming.spliterator;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
public class CustomStreams {

    public static void main(String[] args) {
        var list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        var stream = list.stream();
        var spliterator = stream.spliterator();

        try(Stream<String> lines = Files.lines(Paths.get("src/main/resources/persons.txt"))) {
            var fileSpliterator = lines.spliterator();
            var personSpliterator = new PersonSpliterator(fileSpliterator);
            personSpliterator.forEachRemaining(System.out::println);
        }catch(IOException exception) {
            log.error(exception.getMessage());
        }
    }
}
