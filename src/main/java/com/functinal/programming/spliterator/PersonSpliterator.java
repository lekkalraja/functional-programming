package com.functinal.programming.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonSpliterator implements Spliterator<Person> {

    private String name;
    private int age;
    private String country;
    private String sex;

    private Spliterator<String> fileSpliterator;

    public PersonSpliterator(Spliterator<String> baseSpliterator) {
        this.fileSpliterator = baseSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action) {
        if(this.fileSpliterator.tryAdvance(name -> this.name = name) &&
                this.fileSpliterator.tryAdvance(age -> this.age = Integer.parseInt(age)) &&
                this.fileSpliterator.tryAdvance(country -> this.country = country) &&
                this.fileSpliterator.tryAdvance(sex -> this.sex = sex)
        ){
            action.accept(new Person(this.name, this.age, this.country, this.sex));
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Person> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return this.fileSpliterator.estimateSize() / 4;
    }

    @Override
    public int characteristics() {
        return this.fileSpliterator.characteristics();
    }
}