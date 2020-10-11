package com.functinal.programming.designpatterns;


import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Iterator Design Pattern is a Behavioural(way to communicate Object to Object) design pattern
 *  - It enables to get a way to access the elements of a collection object in sequential manner,
 *    without any need to know it's internal representation.
 */
public class IteratorDP {

    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(new Integer[]{1,2,3,4,5,6,7});
        myList.forEach(System.out::println);

        MyList<String> strings = new MyList<>(new String[]{"Achilleas", "Hector", "Helen", "Troy"});
        strings.forEach(System.out::println);

        List.of(1,2,3,4,5).forEach(System.out::println);
    }

    static class MyList<T> {
        T[] data;

        public MyList(Object[] data) {
            this.data = (T[]) data;
        }

        public void forEach(Consumer<T> consumer) {
            Objects.requireNonNull(consumer);
            for (T element: data) {
                consumer.accept(element);
            }
        }
    }
}