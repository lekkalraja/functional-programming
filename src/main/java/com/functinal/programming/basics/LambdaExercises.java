package com.functinal.programming.basics;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class LambdaExercises {

    public static void main(String[] args) {

        /**
         * Lambda With No Parameter, No Return Type
         */
        Print print = () -> log.info("Hello, Mr. Java");
        print.display();

        /**
         *
         * Lambda With Parameter, No Return Type
         */
        Calculator adder = (a, b) -> log.info("Sum of {}, {} is {}", a, b, a+b);
        adder.operation(2, 4);
        Calculator multiplier = (a, b) -> log.info("Multiplication of {}, {} is {}", a, b, a*b);
        multiplier.operation(3,3);
        Calculator subtract = (a, b) -> log.info("Subtraction of {}, {} is {}", a, b, a-b);
        subtract.operation(5,1);
        Calculator divider = (a, b) -> log.info("Division of {}, {} is {}", a, b, a/b);
        divider.operation(6,2);

        /**
         * Lambda with Parameter And Return Type
         */
        Mapper square = a -> a * a;
        log.info("Square of {} is {}", 9 , square.map(9));

        /**
         * Lambda with Multiple Statements
         */
        Prime prime = a -> {
            boolean isItDivided = IntStream.rangeClosed(2, a / 2)
                    .filter(number -> a % number == 0)
                    .findAny()
                    .isPresent();
            return !isItDivided;
        };
        log.info("15 is Prime : {}", prime.isIt(15));
        log.info("7 is Prime : {}", prime.isIt(7));
    }

    /**
     * Exercise 1 : Method With No Parameter, No Return Type
     */
    @FunctionalInterface
    interface Print {
        void display();
    }

    /**
     * Exercise 2 : Method With Parameter, No Return Type
     */
    interface Calculator {
        void operation(int a, int b);
    }

    /**
     * Exercise 3 : Method with Parameter And Return Type
     */
    interface Mapper{
            int map(int data);
    }

    /**
     * Exercise 4 : Method with Multiple Statements
     */
    interface Prime {
        boolean isIt(int number);
    }
}