package com.functinal.programming.functions;

import java.util.function.Function;

/**
 * Currying will help us to get Partial Functions
 *
 * (U, V) -> fun -> Result
 * U -> fun1 (PF)
 *       v  -> fun2 -> Result
 *
 */
public class Currying {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> curriedFunction = u -> v -> u + v;
        Function<Integer, Integer> partialFunction = curriedFunction.apply(1);
        System.out.println(partialFunction.apply(2));
        System.out.println(partialFunction.apply(3));
        System.out.println(partialFunction.apply(4));
        System.out.println(curriedFunction.apply(4).apply(5));
    }
}