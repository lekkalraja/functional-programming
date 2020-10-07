package com.functinal.programming.predifined;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class PredicateExercise {

    public static void main(String[] args) {

        List<String> listOfNames = List.of("Achilleas", "Hector", "", "Helen", "", "", "Troy");
        Predicate<String> emptyStringFilter = String::isEmpty;
        log.info(filterList(listOfNames, emptyStringFilter).toString());

        List<Integer> listOfIntegers = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
        Predicate<Integer> nonPrimerFilter = item -> IntStream.rangeClosed(2, item / 2)
                .filter(number -> item % number == 0)
                .findAny().isPresent();
        log.info(filterList(listOfIntegers, nonPrimerFilter).toString());
    }

    /**
     * Exercise : Filter out list strings by using provided predicate
     */
    static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate.negate())
                .collect(Collectors.toList());
    }
}