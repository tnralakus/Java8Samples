package com.samples.java8.stream;

import java.util.*;

/**
 * Created by Alakus on 12/1/2015.
 */
public class StreamExample {
    public static void main(String[] args) {
        Map<String, Person> personMap = new HashMap<>();
        personMap.computeIfAbsent("taner", name -> new Person(name, 0));
        System.out.println(personMap.get("taner"));

        Comparator personComparator = Comparator.comparing(Person::getName).reversed();
        List<Person> personList = Arrays.asList(new Person("taner", 1), new Person("alakus", 2));
        personList.sort(personComparator);
        personList.forEach(System.out::println);
    }
}

