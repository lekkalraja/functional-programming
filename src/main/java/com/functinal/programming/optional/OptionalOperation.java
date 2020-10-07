package com.functinal.programming.optional;

import java.util.Optional;
import java.util.Random;

public class OptionalOperation {

    public static void main(String[] args) {

        //map
        getOptionalString()
                .map(String::length)
                .ifPresent(System.out::println);

        //filter
        getOptionalString()
                .filter(item -> item.startsWith("Op"))
                .ifPresent(System.out::println);

        //filter
        getOptionalString()
                .flatMap(item -> Optional.of(item.toLowerCase()))
                .ifPresent(System.out::println);

        //ifPresentOrElse
        getOptionalString()
                .ifPresentOrElse(System.out::println, () -> System.out.println("You are Off!!"));

        //or
        getOptionalString()
                .or(() -> Optional.of("Other Optional"))
                .ifPresent(System.out::println);

        //stream
        getOptionalString().stream()
                .forEach(System.out::println);

        //equals
        System.out.println(getOptionalString().equals(getOptionalString()));
    }

    static Optional<String> getOptionalString() {
        var random = new Random();
        return random.nextBoolean() ? Optional.of("Optional") : Optional.empty();
    }
}