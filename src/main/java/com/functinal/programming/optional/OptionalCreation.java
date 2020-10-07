package com.functinal.programming.optional;

import java.util.Optional;

public class OptionalCreation {

    public static void main(String[] args) {
        // Creating Optional With a non-null value
        String value = "Achilleas";
        Optional<String> optionalValue = Optional.of(value);
        //Optional.of(null); // will get Null pointer exception

        // Creating an empty optional
        Optional<Object> emptyOptional = Optional.empty();

        // Creating an optional for a non predictable value i.e. the value might be null or empty
        String mayBe = "Test";
        Optional<String> mayBe1 = Optional.ofNullable(mayBe);
        mayBe = null;
        Optional<String> mayBe2 = Optional.ofNullable(mayBe);
    }
}
