package com.functinal.programming.functions;

import lombok.extern.slf4j.Slf4j;

/**
 * A Closure is a function that refers to free variables in it's lexical context
 */
@Slf4j
public class Closure {

    public static void main(String[] args) {
        Integer mainVariable = 1293;
       // mainVariable = 232; => Variable used in lambda expression should be final or effectively final
        ITask<Integer> task = () -> {
            //mainVariable = 223; => Variable used in lambda expression should be final or effectively final
            log.info("Got Variable from Main method {}. Hahahah", mainVariable);
            return mainVariable;
        };
        thief(task);
    }

    static <T> void thief(ITask<T> task) {
        T t = task.doTask();
        log.info("{} => Got From Main() out of scope with the help of Closure", t);
    }

    @FunctionalInterface
    interface ITask<T> {
        T doTask();
    }
}