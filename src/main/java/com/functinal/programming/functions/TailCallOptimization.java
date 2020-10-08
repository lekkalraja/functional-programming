package com.functinal.programming.functions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TailCallOptimization {

    public static void main(String[] args) {
        log.info("Factorial of {} is {}", 10 , refact(10));
        log.info("Factorial of {} is {}", 10 , refactWithTCO(10, 1L));
    }

    static Long refact(int number) {
        if (number == 1) {
            return 1L;
        } else {
            return number * refact(number -1);
        }
    }

    static Long refactWithTCO(int number, Long accumulator) {
        if(number == 1) {
            return accumulator;
        } else {
            return refactWithTCO(number - 1, number * accumulator);
        }
    }
}
