package com.functinal.programming.designpatterns;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Fluent Interface Design (it is not Gang of Four DP)
 *  - It provides an easy-readable, flowing interface, that often mimics a domain specific language.
 *    Using this pattern results in code that can be read nearly as human language.
 */
@Slf4j
public class FluentInterfaceDP {

    public static void main(String[] args) {
        Order.place(order -> order.add("Shoes").add("HeadPhones").address("Singapore 45, Singapore"));
    }

    static class Order {
        private List<String> items = new ArrayList<>();
        private String address;

        private Order() {}

        private Order add(String item) {
            log.info("Adding item : {}", item);
            items.add(item);
            return this;
        }

        private Order address(String address) {
            log.info("Setting Delivery Address : {}", address);
            this.address = address;
            return this;
        }

        public static void place(Function<Order, Order> checkout) {
            Order order = new Order();
            Order finalOrder = checkout.apply(order);
            log.info("Everything set for Delivery.. Orders : {} , Delivery Location : {}", finalOrder.items, finalOrder.address);
        }
    }
}