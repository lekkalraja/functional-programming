package com.functinal.programming.predifined;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class BiFunctionPractice {

    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (left, right) -> left.concat(right);
        log.info("Concatenation of {} and {} is {}", "Raja", "Rani", concatenate.apply("Raja", "Rani"));
        Function<String, Integer> length = item -> item.length();
        BiFunction<String, String, Integer> andThen = concatenate.andThen(length);
        log.info("Concatenation of {} and {} and Final Length is {}", "Raja", "Rani", andThen.apply("Raja", "Rani"));
    }
}
