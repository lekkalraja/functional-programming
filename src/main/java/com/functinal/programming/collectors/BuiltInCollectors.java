package com.functinal.programming.collectors;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
public class BuiltInCollectors {

    public static void main(String[] args) {
        try (Stream<String> employees = Files.lines(Paths.get("src/main/resources/employees.csv"))) {
            //employees.forEach(System.out::println);
            Spliterator<String> spliterator = employees.spliterator();
            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(spliterator);
            //employeeSpliterator.forEachRemaining(System.out::println);
            Stream<Employee> employeeStream = StreamSupport.stream(employeeSpliterator, false);
            List<Employee> employeeList = employeeStream.collect(Collectors.toList());
            //employeeStream.forEach(System.out::println);

            List<Employee> sortedBySurName = employeeList.stream()
                    .sorted((e1, e2) -> e1.surName().compareTo(e2.surName))
                    .collect(Collectors.toList());
            //sortedBySurName.forEach(System.out::println);

            TreeSet<Employee> sortedByGivenName = employeeList.stream()
                    .collect(Collectors.toCollection(TreeSet::new));
            //sortedByGivenName.forEach(System.out::println);

            Map<Integer, String> idNames = employeeList.stream()
                    .collect(Collectors.toMap(e -> e.id(), e -> e.givenName()));
            //System.out.println(idNames);

            /**
             * Partitioning based on partition key (branching)
             */
            Map<Boolean, List<Employee>> genderBasedEmployees = employeeList.stream()
                    .collect(
                            Collectors.partitioningBy(emp -> emp.gender.equals("M"))
                    );
            //System.out.println(genderBasedEmployees.keySet());

            Map<String, List<Employee>> groupByDivision = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(Employee::division)
                    );
            //System.out.println(groupByDivision);

            Map<String, Long> countingByDivision = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Employee::division,
                                    Collectors.counting()
                            )
                    );
            //System.out.println(countingByDivision);

            Map<String, Double> divisionTotalSalary = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Employee::division,
                                    Collectors.summingDouble(Employee::salary)
                            )
                    );
            //System.out.println(divisionTotalSalary);

            Map<String, Optional<Employee>> maxSalariedEmployeeInTheDivision = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Employee::division,
                                   // Collectors.maxBy((e1, e2) -> (int) (e1.salary - e2.salary))
                                    Collectors.maxBy(Comparator.comparing(Employee::salary))
                            )
                    );
            //System.out.println(maxSalariedEmployeeInTheDivision);

            Map<String, Optional<Double>> maxSalaryInDivision = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Employee::division,
                                    Collectors.mapping(
                                            Employee::salary,
                                            Collectors.maxBy((sal1, sal2) -> (int) (sal1 - sal2))
                                    )
                            )
                    );
            //System.out.println(maxSalaryInDivision);
        }catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }


    public static class EmployeeSpliterator implements Spliterator<Employee> {

        final private Spliterator<String> baseIterator;

        public EmployeeSpliterator(Spliterator<String> baseIterator) { this.baseIterator = baseIterator; }

        @Override
        public boolean tryAdvance(Consumer<? super Employee> action) {
            try {
                return this.baseIterator.tryAdvance(line -> {
                    String[] words = line.split(",");
                    Employee employee = new Employee(Integer.parseInt(words[0]), words[1], words[2], words[3], words[4], words[5],
                            words[6], words[7], words[8], Double.parseDouble(words[9]),
                            Double.parseDouble(words[10]), Double.parseDouble(words[11]), words[12]);
                    action.accept(employee);
                });
            }catch (Exception e) { log.error("Failed to convert message {}", e.getMessage()); }
            return true;
        }

        @Override
        public Spliterator<Employee> trySplit() { return null; }

        @Override
        public long estimateSize() {
            return this.baseIterator.estimateSize();
        }

        @Override
        public int characteristics() { return this.baseIterator.characteristics(); }
    }

    public record Employee(int id, String surName, String givenName, String gender, String city, String jobTitle,
                           String deptName, String location, String division, double age, double experience, double salary, String unit)
        implements Comparable<Employee> {
        @Override
        public int compareTo(Employee o) {
            return this.givenName.compareTo(o.givenName);
        }
    }
}