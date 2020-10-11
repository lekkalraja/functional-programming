package com.functinal.programming.designpatterns;

import java.util.function.Supplier;

/**
 * Factory Design Pattern is a Creational Pattern i.e. Creating object without exposing instantiation logic.
 * - It is a way to instantiating a class inside a designated method that we call a factory method.
 * - `Factory is an object that is able to create other objects`
 */
public class FactoryDP {

    public static void main(String[] args) {
        FloorFactory.getInstance().installation();
    }

    static class FloorFactory {
        public static Flooring getInstance() {
            // Based on location fetch the min and max temp
            int minTemp = 4;
            int maxTemp = 21;
            Supplier<Flooring> flooring;
            if ( minTemp <= 4 && maxTemp <= 20 ) {
                flooring = WoodenFlooring::new;
            } else if (( minTemp <= 2 && maxTemp <= 40 )) {
                flooring = CorkFlooring::new;
            } else {
                flooring = ConcreteFlooring::new;
            }
            return flooring.get();
        }
    }


    interface Flooring {
        void installation();
    }

    static class WoodenFlooring implements Flooring {
        @Override
        public void installation() {
            System.out.println("Wooden floor has been installed");
        }
    }

    static class CorkFlooring implements Flooring {
        @Override
        public void installation() {
            System.out.println("Cork Floor has been installed");
        }
    }

    static class ConcreteFlooring implements Flooring {
        @Override
        public void installation() {
            System.out.println("Concrete Floor has been installed");
        }
    }
}