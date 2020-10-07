package com.functinal.programming.predifined;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class FunctionExercise {

    public static void main(String[] args) {

        List<String> names = List.of("Achilleas", "Hector", "Helen", "Agamemnon", "Troy");
        Function<String, Integer> lengthMapper = String::length;
        map(names, lengthMapper).forEach(System.out::println);

        Function<Integer, Integer> subtract = item -> item - 1;
        Function<String, Integer> compose = subtract.compose(lengthMapper);
        map(names, compose).forEach(System.out::println);

        Function<Integer, Integer> adder = item -> item + 1;
        Function<String, Integer> andThen = lengthMapper.andThen(adder);
        map(names, andThen).forEach(System.out::println);

        List<Integer> integers = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
        Function<Integer, Integer> square = item -> item * item;
        map(integers, square).forEach(System.out::println);

        Function<Integer, Integer> identity = item -> item;
        map(integers, identity).forEach(System.out::println);
    }

    static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        return list.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}