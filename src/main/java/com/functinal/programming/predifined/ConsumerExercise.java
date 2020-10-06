package com.functinal.programming.predifined;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class ConsumerExercise {

    public static void main(String[] args) {
        List<String> listOfNames = List.of("Achilleas", "Hector", "", "Helen", "", "", "Troy");
        Consumer<String> displayLength = item -> log.info("Length of the String {} is {}", item, item.length());
        Consumer<String> printLengthAndThenExtract3Chars = displayLength.andThen(item -> log.info("First Three Characters of {} is {}", item, item.length() > 4 ? item.substring(0, 3) : item));
        print(listOfNames, printLengthAndThenExtract3Chars);
    }

    /**
     * Print the provided list by passing through consumer
     */
    static <T> void print(List<T> list, Consumer<T> consumer) {
        list.forEach(consumer);
    }
}
