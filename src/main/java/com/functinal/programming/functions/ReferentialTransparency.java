package com.functinal.programming.functions;


import lombok.extern.slf4j.Slf4j;

/**
 * Referential Transparency is A property of a function, variable,
 * or expression whereby the expression can be replaced by its(evaluated)
 * value without affecting the behaviour of the program
 */
@Slf4j
public class ReferentialTransparency {

    public static void main(String[] args) {
        int add = add(2, 6);
        int add1 = add(2, add(3, 3));
        boolean check = add == add1;
        log.info("Add {} and add1 {} are same : {}", add, add1, check);

        /**
         * Even though values are same but the mul function log statements are not same,
         * so it's failed for ReferentialTransparency
         */
        int mul = mul(2, 6);
        int mul1 = mul(2, mul(3, 2));
        boolean check1 = add == add1;
        log.info("Mul {} and Mul1 {} are same : {}", mul, mul1, check1);

    }

    static int add(int a, int b) {
        return a + b;
    }

    static int mul(int a, int b) {
        log.info("Multiplying a {} and b{}", a, b); // Broken Referential Transparency becoz mul(2,4) is not same as mul(2, mul(2,2))
        return a * b;
    }
}
