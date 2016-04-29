package com.samples.java8.functionalInterface;

import java.util.Comparator;

/**
 * Created by alakus on 4/26/2016.
 */
public class Comparators {

    public static void main(String[] args) {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2); // > 0
        comparator.reversed().compare(p1, p2); // < 0
    }
}
