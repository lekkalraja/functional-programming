package com.functinal.programming.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Random;

@Slf4j
public class OptionalUnWrap {

    public static void main(String[] args) {
        /**
         * -- get()--
         * There is a chance of getting java.util.NoSuchElementException: No value present if we call directly .get
         */
        log.info("Got Optional Value : {}", 0/*getOptional().get()*/);

        /**
         * -- isPresent()--
         * It's safe to check first whether element is present or not by calling isPresent
         */
        var optional = getOptional();
        log.info("Got Optional Value : {}", optional.isPresent() ? optional.get() : 0);

        /**
         *  orElse(T other) -> If Value presents gives that other wise return's default value
         *  orElseGet(Supplier<? extends T> supplier) -> If Value presents gives that other wise will execute supplier to return value
         *  orElseThrow(Supplier<? extends X> exceptionSupplier) -> If Value presents gives that other wise will execute supplier to throw error
         *  orElseThrow() -> If Value presents gives that other wise will throw NoSuchElementException("No value present")
         */
        log.info("Got Optional Value : {}", getOptional().orElse(10));
        log.info("Got Optional Value : {}", getOptional().orElseGet(() -> 10));
        log.info("Got Optional Value : {}", getOptional().orElseThrow(IllegalArgumentException::new));
        log.info("Got Optional Value : {}", getOptional().orElseThrow());


    }

    static Optional<Integer> getOptional() {
        var random = new Random();
        return random.nextBoolean() ? Optional.of(100) : Optional.empty();
    }
}
