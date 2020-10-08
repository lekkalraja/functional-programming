package com.functinal.programming.functions;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Composition {

    public static void main(String[] args) {
        IFunction<String, String> fun1 = item -> item.concat(" 1");
        log.info("Output of Fun1 : {}", fun1.apply("Composing"));
        IFunction<String, String> fun2 = item -> item.concat(" 2");
        IFunction<String, String> compose1 = fun1.compose(fun2);
        log.info("Output of Compose1 : {}", compose1.apply("Composing"));
        IFunction<String, String> fun3 = item -> item.concat(" 3");
        IFunction<String, String> compose2 = compose1.compose(fun3);
        log.info("Output of Compose2 : {}", compose2.apply("Composing"));
        IFunction<String, String> compose2a = fun1.compose(fun2).compose(fun3);
        log.info("Output of Compose2a : {}", compose2a.apply("Composing"));
    }

    @FunctionalInterface
    interface IFunction<T, R> {
        R apply(T t);

        default <V> IFunction<V, R> compose(IFunction<V, T> before) {
            Objects.requireNonNull(before);
            return (V t) -> this.apply(before.apply(t));
        }
    }
}