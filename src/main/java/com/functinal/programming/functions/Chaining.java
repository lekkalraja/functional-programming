package com.functinal.programming.functions;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Chaining {

    public static void main(String[] args) {
        IFunction<String, String> fun1 = item -> item.concat(" 1");
        log.info("Output of Fun1 : {}", fun1.apply("Chaining"));
        IFunction<String, String> fun2 = item -> item.concat(" 2");
        IFunction<String, String> funChain1 = fun1.andThen(fun2);
        log.info("Output of FunChain1 : {}", funChain1.apply("Chaining"));
        IFunction<String, String> fun3 = item -> item.concat(" 3");
        IFunction<String, String> funChain2 = funChain1.andThen(fun3);
        log.info("Output of FunChain2 : {}", funChain2.apply("Chaining"));
        funChain2.andThen(null).apply("Test");
    }

    @FunctionalInterface
    interface IFunction<T,R> {
        R apply(T t);

        default IFunction<T, R> andThen(IFunction<R, R> next) {
            Objects.requireNonNull(next, "Don't  Send Null Function!!");
            return (T t) -> next.apply(this.apply(t));
        }
    }
}