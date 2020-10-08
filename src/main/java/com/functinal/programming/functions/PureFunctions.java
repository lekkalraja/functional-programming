package com.functinal.programming.functions;


import lombok.extern.slf4j.Slf4j;

/**
 * A Pure Function will take input and gives same output for same input always
 *  - No Mutation
 *  - No Side Effects
 *      - Will not read data from outside of function state, no IO call's
 *      - Will no write data to outside of function, no IO Call's
 */
@Slf4j
public class PureFunctions {

    public static void main(String[] args) {

        int add = add(1, 3);
        log(add);
    }

    /**
     * Pure Function : Takes 2 inputs and produce based on the inputs
     *  Note: Ouput is always same for the same input
     * @param a
     * @param b
     * @return
     */
    static int add(int a, int b) {
        return a + b;
    }

    /**
     * Impure Function
     *  Note : Has side effect i.e. logging and not return anything
     * @param c
     */
    static void log(int c) {
        log.info("Logging {}", c);
    }
}
