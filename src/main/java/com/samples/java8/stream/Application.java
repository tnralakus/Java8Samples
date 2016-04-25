package com.samples.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

/**
 * Created by Alakus on 12/2/2015.
 */
public class Application {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Veli", "Selami", "Cem", "Zeynel", "Can", "Hüseyin");
        Stream<String> stream = names.stream();
        Stream<String> parallelStream = names.parallelStream();

        parallelStream = stream.parallel();
        stream = parallelStream.sequential();

        // stream.forEach(System.out::println);

        Stream<String> filtered = stream.filter(name -> name.length() > 4);
        filtered.forEach(System.out::println);

        IntStream intStream = IntStream.of(1, 1, 2, 3, 5, 8, 13, 13, 8);
        intStream.distinct().forEach(System.out::println);

        IntStream unSortedStream = IntStream.of(13, 1, 3, 5, 8, 1, 13, 2, 8);
        unSortedStream.sorted().forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("**********");
        try {
            Path dir = Paths.get(".");
            Stream<Path> pathStream = Files.list(dir);
            pathStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        IntStream intOf = IntStream.of(1, 2, 3);
        IntStream intRange = IntStream.range(1, 10);
        DoubleStream doubleOf = DoubleStream.of(1.0, 3.5, 6.6);
        LongStream longOf = LongStream.of(3, 5, Long.MAX_VALUE, 9);
        LongStream longRange = LongStream.range(1, 100);

		LongStream range = LongStream.range(1, 10000);
        range.limit(10).forEach(System.out::println);

        IntStream rangeI = IntStream.range(1, 10);
        IntStream rangeClosed = IntStream.rangeClosed(1, 10);
        System.out.println(rangeI.count());
        System.out.println(rangeClosed.count());

        List<String> list = names.stream().collect(Collectors.toList());
        Set<String> set = names.stream().collect(Collectors.toSet());
        Long count = names.stream().collect(Collectors.counting());
        String collect = names.stream().collect(Collectors.joining(" - "));
        Map<Integer, List<String>> integerListMap = names.stream().collect(Collectors.groupingBy(name -> name.length()));


        Stream<String> upperStream = names.stream().map(name -> name.toUpperCase());
        List<String> upperNames = upperStream.collect(Collectors.toList());
        upperNames.forEach(System.out::println);

        IntStream.rangeClosed(1, 5).map(i -> i * i).forEach(System.out::println);

        int result = IntStream.of(1, 2, 3, 4, 5)
                .reduce(0, (first, second) -> {
                    System.out.format("%d - %d %n", first, second);
                    return first + second;
                });
        result = IntStream.of(1, 2, 3, 4, 5).reduce(1, Math::multiplyExact);
        System.out.println(result);


        Person p1 = new Person("Ahmet", 10);
        Person p2 = new Person("Ali", 20);
        Person p3 = new Person("Ayşe", 30);
        Person p4 = new Person("Murat", 40);
        Person p5 = new Person("Zeynep", 50);
        List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5);
        Double sum = personList.stream().filter(Objects::nonNull).map(a -> a.getAge()).map(Double::valueOf).reduce(0d, (a, b) -> (a + b));
        System.out.println(sum);

        IntStream iStream = IntStream.range(0, 10);
		iStream=iStream.filter(Objects::nonNull); // Lazy
		iStream=iStream.filter(n -> n % 2 == 1); // Lazy
		iStream=iStream.map(n -> n * 2); // Lazy
		iStream.forEach(System.out::println); // Eager
    }
}
