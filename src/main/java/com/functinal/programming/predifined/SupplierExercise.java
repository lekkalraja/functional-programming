package com.functinal.programming.predifined;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.function.Supplier;

@Slf4j
public class SupplierExercise {

    public static void main(String[] args) {
        Supplier<String> item = () -> "Item";
        log.info("Supply Stirng : {}", item.get());

        Supplier<Double> random = () -> new Random().nextDouble();
        log.info("Get Random Number : {}", random.get());
        log.info("Get Random Number : {}", random.get());
        log.info("Get Random Number : {}", random.get());
    }
}
