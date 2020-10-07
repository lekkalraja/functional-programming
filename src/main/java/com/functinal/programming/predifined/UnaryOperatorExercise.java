package com.functinal.programming.predifined;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnaryOperatorExercise {

    public static void main(String[] args) {

        UnaryOperator<Integer> multiplier = item -> item * 100;
        List<Integer> integers = IntStream.rangeClosed(0, 15).boxed().collect(Collectors.toList());
        mapper(integers, multiplier).forEach(System.out::println);

        /**
         * Identity
         */
        mapper(integers, UnaryOperator.identity()).forEach(System.out::println);

    }

    static <T> List<T> mapper(List<T> input, UnaryOperator<T> mapper) {
        return input.stream()
                .map(mapper).collect(Collectors.toList());
    }
}
