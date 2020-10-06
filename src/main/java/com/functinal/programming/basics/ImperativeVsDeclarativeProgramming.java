package com.functinal.programming.basics;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class ImperativeVsDeclarativeProgramming {

    public static void main(String[] args) {
        /**
         * Imperative style of Programming (What to do)
         */
        int sumOfEvens = 0; //Mutable Variable
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sumOfEvens += i;
            }
        }
        log.info("Sum of Evens : {}", sumOfEvens);

        /**
         * Declarative or Functional Programming (How to do)
         * Note : No Mutation Involved
         */
        int sumOfOdds = IntStream.rangeClosed(0, 100)
                .filter(i -> i % 2 == 0)
                .reduce((left, right) -> left + right)
                .getAsInt();
        log.info("Sum of Odds : {}", sumOfOdds);
    }
}
