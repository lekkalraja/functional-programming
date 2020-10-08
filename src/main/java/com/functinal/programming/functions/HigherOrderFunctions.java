package com.functinal.programming.functions;

import lombok.extern.slf4j.Slf4j;

/**
 * HigherOrderFunctions :
 *  IF :
 *      - Function takes input argument as a function
 *      - Function returns function as output
 *      - Function can take input as a function and also can return function as a output
 *
 */
@Slf4j
public class HigherOrderFunctions {

    public static void main(String[] args) {
        IProducer producer = () -> Math.random()*100;
        IConfigurator<Double, Integer> intConfigurator = item -> item.intValue();
        IFactory factory = createFactory(producer, intConfigurator);
        log.info("Produced Item {}", factory.create());
    }
    static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
        return () -> {
            T source = producer.produce();
            return configurator.configure(source);
        };
    }

    interface IFactory<R> {
        R create();
    }

    interface IProducer<T> {
        T produce();
    }

    interface IConfigurator<T, R> {
        R configure(T element);
    }
}