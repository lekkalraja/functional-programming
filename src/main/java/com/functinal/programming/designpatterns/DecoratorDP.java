package com.functinal.programming.designpatterns;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * Decorator Design pattern is a Behavioural Design pattern
 *   - Used to modify functionality of object at runtime without affecting other instances of the same class.
 */
@Slf4j
public class DecoratorDP {

    public static void main(String[] args) {
        Burger baseBurger = new Burger();
        Burger cheeseBurger = BurgerShop.use(baseBurger, Burger::addCheese);
        Burger veggieCheeseBurger = BurgerShop.use(cheeseBurger, Burger::addVeggies);
        log.info("Got {}", veggieCheeseBurger);
    }

    static class BurgerShop {
        public static Burger use(Burger baseBurger, Function<Burger, Burger> decorator) {
            return decorator.apply(baseBurger);
        }
    }

    static class Burger {
        private final String burgerType;

        public Burger() {
            this.burgerType = "";
        }

        private Burger(String addOn) {
            this.burgerType = addOn;
        }

        /**
         * Decorators
         */

        public Burger addCheese() {
            log.info("Adding Cheese To the {}",this);
            return new Burger(this.burgerType + " " + "Cheese");
        }

        public Burger addVeggies() {
            log.info("Adding Veggies to the {}", this);
            return new Burger(this.burgerType +" "+ "Veggies");
        }

        @Override
        public String toString() {
            return String.format("%s Burger", burgerType);
        }
    }
}
