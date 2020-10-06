package com.functinal.programming;


import lombok.extern.slf4j.Slf4j;

/**
 * LAMBDA is a building block for functional programming in Java
 *
 * It is a implementation for the @Functional Interface
 */
@Slf4j
public class FirstLambda {

    public static void main(String[] args) {

        /**
         * 1 - A way of implementing Functional Interface (Runnable - Had single abstract method) with ImplementationClass
         */
        Thread implementationClassThread = new Thread(new MyRunnable());
        implementationClassThread.start();

        /**
         * 2 - A Way of providing implementation to interfaces with AnonymousInnerClass Technique
         */
        Thread anonymousInnerClassThread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("Running Anonymous InnerClass on {}", Thread.currentThread().getName());
            }
        });
        anonymousInnerClassThread.start();

        /**
         * 3 - A way of providing Lambda implementation for Functional Interface (Runnable)
         */

        Thread lambdaThread = new Thread(() -> log.info("Running Lambda Implementation on {}", Thread.currentThread().getName()));
        lambdaThread.start();
    }


    /**
     * Implementation of Runnable Interface (Functional)
     */
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log.info("Running Implementation Class on {}", Thread.currentThread().getName());
        }
    }
}