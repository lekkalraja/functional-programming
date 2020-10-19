package com.functinal.programming.collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;

/**
 * stream.collect(Collector)
 *  - 1. Collector (Interface)
 *     public interface Collector<T, A, R> {
 *          Supplier<A> supplier();
 *          BiConsumer<A, T> accumulator();
 *          BinaryOperator<A> combiner();
 *          Function<A, R> finisher();
 *          Set<Characteristics> characteristics();
 *     }
 *  - 2. Collector Implementation
 *          static class CollectorImpl<T, A, R> implements Collector<T, A, R>
 *          return new CollectorImp<>(
 *              supplier, accumulator, finisher, combiner, characteristics
 *          );
 *
 *  - 3. Sequence of execution when we call stream.collect(collector)
 *      1. A container = collector.supplier.get();
 *      2. BiConsumer accumulator = collector.accumulator();
 *      3. forEach(u -> accumulator.accept(container, u));
 *      4. // combining Step if parallel
 *      5. return collector.finisher().apply(container)
 */
public class CustomCollectors {

    public static void main(String[] args) {
        List<Integer> source = List.of(1, 4, 3, 6, 8, 3, 2, 5, 7, 8, 9, 3, 1, 5, 34, 23, 1, 5, 3, 34, 23, 45, 23, 46, 776, 78);

        Collector<Integer, ArrayList<Integer>, ArrayList<Integer>> myList = Collector.of(() -> new ArrayList<>(), // Supplier
                (container, item) -> container.add(item), // Accumulator
                (left, right) -> {
                    left.addAll(right);
                    return left;
                }, // Combiner
                Collector.Characteristics.IDENTITY_FINISH
        );
        ArrayList<Integer> evens = source.stream().filter(item -> item % 2 == 0).collect(myList);
        System.out.println(evens);

        Collector<Integer, TreeSet<Integer>, TreeSet<Integer>> sortCollector = Collector.of(TreeSet::new, // Supplier
                TreeSet::add, // Accumulator
                (left, right) -> {
                    left.addAll(right);
                    return right;
                }, // Combiner
                Collector.Characteristics.UNORDERED
        );
        TreeSet<Integer> sortList = source.stream().collect(sortCollector);
        System.out.println(sortList);

        Collector<Integer, ArrayList<Integer>, ArrayList<Integer>> collectionsSorting = Collector.of(ArrayList::new, // Supplier
                ArrayList::add, // Accumulator
                (left, right) -> {
                    left.addAll(right);
                    return left;
                }, // Combiner
                list -> {
                    Collections.sort(list);
                    return list;
                }, // Finisher
                Collector.Characteristics.UNORDERED
        );
        ArrayList<Integer> sorted = source.stream().collect(collectionsSorting);
        System.out.println(sorted);

    }
}