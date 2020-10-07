package com.functinal.programming.predifined;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BinaryOperator;

@Slf4j
public class BinaryOperatorExercise {

    public static void main(String[] args) {
        /**
         * public interface BinaryOperator<T> extends BiFunction<T,T,T>
         */
        BinaryOperator<String> concatenate = (left, right) -> left.concat("_").concat(right);
        log.info("Concatenating {} and {} with Seperater {} is : {}", "Raja", "Rani", "_", concatenate.apply("Raja", "Rani"));
    }
}