package com.samples.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by alakus on 4/29/2016.
 */
public class StreamTutorials {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
            .stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
        // C1
        // C2

        Arrays.asList("a1", "a2", "a3")
            .stream()
            .findFirst()
            .ifPresent(System.out::println); // a1

        Stream.of("a1", "a2", "a3")
            .findFirst()
            .ifPresent(System.out::println); // a1

        IntStream.range(1, 4)
            .forEach(System.out::println);
        // 1
        // 2
        // 3

        Arrays.stream(new int[] {1, 2, 3})
            .map(n -> 2 * n + 1)
            // .peek(System.out::println)
            .average()
            .ifPresent(System.out::println); // 5.0

        Stream.of("a1", "a2", "a3")
            .map(s -> s.substring(1))
            .mapToInt(Integer::parseInt)
            .max()
            .ifPresent(System.out::println); // 3

        IntStream.range(1, 4)
            .mapToObj(i -> "a" + i)
            .forEach(System.out::println);
        // a1
        // a2
        // a3

        Stream.of(1.0, 2.0, 3.0)
            .mapToInt(Double::intValue)
            .mapToObj(i -> "a" + i)
            .forEach(System.out::println);
        // a1
        // a2
        // a3

        Stream.of("d2", "a2", "b1", "b3", "c")
            .filter(s -> {
				System.out.println("filter: " + s);
				return true;
			})
            .forEach(s -> System.out.println("forEach: " + s));

        Stream.of("d2", "a2", "b1", "b3", "c")
            .map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
            .anyMatch(s -> {
				System.out.println("anyMatch: " + s);
				return s.startsWith("A");
			});
        // map: d2
        // anyMatch: D2
        // map: a2
        // anyMatch: A2

        Stream.of("d2", "a2", "b1", "b3", "c")
            .map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
            .filter(s -> {
				System.out.println("filter: " + s);
				return s.startsWith("A");
			})
            .forEach(s -> System.out.println("forEach: " + s));
        // map: d2
        // filter: D2
        // map: a2
        // filter: A2
        // forEach: A2
        // map: b1
        // filter: B1
        // map: b3
        // filter: B3
        // map: c
        // filter: C

        Stream.of("d2", "a2", "b1", "b3", "c")
            .filter(s -> {
				System.out.println("filter: " + s);
				return s.startsWith("a");
			})
            .map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
            .forEach(s -> System.out.println("forEach: " + s));
            // filter: d2
            // filter: a2
            // map: a2
            // forEach: A2
            // filter: b1
            // filter: b3
            // filter: c

        // sorted is executed horizontally.
        Stream.of("d2", "a2", "b1", "b3", "c")
            .sorted((s1, s2) -> {
				System.out.printf("sort: %s; %s\n", s1, s2);
				return s1.compareTo(s2);
			})
            .filter(s -> {
				System.out.println("filter: " + s);
				return s.startsWith("a");
			})
            .map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
            .forEach(s -> System.out.println("forEach: " + s));

        Stream.of("d2", "a2", "b1", "b3", "c")
            .filter(s -> {
				System.out.println("filter: " + s);
				return s.startsWith("a");
			})
            .sorted((s1, s2) -> {
				System.out.printf("sort: %s; %s\n", s1, s2);
				return s1.compareTo(s2);
			})
            .map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
            .forEach(s -> System.out.println("forEach: " + s));
        // filter: d2
        // filter: a2
        // filter: b1
        // filter: b3
        // filter: c
        // map: a2
        // forEach: A2

        Stream<String> stream =
            Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true); // ok
        // stream.noneMatch(s -> true); // exception

        Supplier<Stream<String>> streamSupplier =
            () -> Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true); // ok
        streamSupplier.get().noneMatch(s -> true); // ok

        System.out.println("***********************************");

        List<Person> persons =
            Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));

        List<Person> filtered =
            persons
                .stream()
                .filter(p -> p.getName().startsWith("P"))
                .collect(Collectors.toList());
        System.out.println(filtered); // [Peter, Pamela]

        Map<Integer, List<Person>> personsByAge = persons
            .stream()
            .collect(Collectors.groupingBy(p -> p.getAge()));
        personsByAge
            .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
        // age 18: [Max]
        // age 23: [Peter, Pamela]
        // age 12: [David]

        Double averageAge = persons
            .stream()
            .collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println(averageAge); // 19.0

        IntSummaryStatistics ageSummary =
            persons
                .stream()
                .collect(Collectors.summarizingInt(p -> p.getAge()));
        System.out.println(ageSummary);
        // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

        String phrase = persons
            .stream()
            .filter(p -> p.getAge() >= 18)
            .map(p -> p.getName())
            .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
        System.out.println(phrase);
        // In Germany Max and Peter and Pamela are of legal age.

        Map<Integer, String> map = persons
            .stream()
            .collect(Collectors.toMap(
					p -> p.getAge(),
					p -> p.getName(),
					(name1, name2) -> name1 + ";" + name2));
        System.out.println(map);
        // {18=Max, 23=Peter;Pamela, 12=David}

        Collector<Person, StringJoiner, String> personNameCollector =
            Collector.of(
                () -> new StringJoiner(" | "), // supplier
                (j, p) -> j.add(p.getName().toUpperCase()), // accumulator
                (j1, j2) -> j1.merge(j2), // combiner
                StringJoiner::toString); // finisher
        String names = persons
            .stream()
            .collect(personNameCollector);
        System.out.println(names); // MAX | PETER | PAMELA | DAVID

        List<Foo> foos = new ArrayList<>();

        // create foos
        IntStream
            .range(1, 4)
            .forEach(i -> foos.add(new Foo("Foo" + i)));

        // create bars
        foos.forEach(f -> IntStream
            .range(1, 4)
            .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

		foos.stream()
				//.map(f -> f.bars.stream())
				//.forEach(s -> s.forEach(b -> System.out.println(b.name)));
				.flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));

		System.out.println("***********************************");
		IntStream.range(1, 4)
				.mapToObj(i -> new Foo("Foo" + i))
				.peek(f -> IntStream.range(1, 4)
						.mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
						.forEach(f.bars::add))
				.flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));


		Outer outer = new Outer();
		if (outer != null && outer.nested != null && outer.nested.inner != null) {
			System.out.println(outer.nested.inner.foo);
		}
		Optional.of(new Outer())
				.flatMap(o -> Optional.ofNullable(o.nested))
				.flatMap(n -> Optional.ofNullable(n.inner))
				.flatMap(i -> Optional.ofNullable(i.foo))
				.ifPresent(System.out::println);


		persons
				.stream()
				.reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
				.ifPresent(System.out::println);    // Pamela

		Person result =
				persons
						.stream()
						.reduce(new Person("", 0), (p1, p2) -> {
							p1.setAge(p1.getAge() + p2.getAge());
							p1.setName(p1.getName() + p2.getName());
							return p1;
						});

		System.out.format("name=%s; age=%s", result.getName(), result.getAge());
		// name=MaxPeterPamelaDavid; age=76

		System.out.println();
		Integer ageSum = persons
				.stream()
				.reduce(0, (sum, p) -> sum += p.getAge(), (sum1, sum2) -> sum1 + sum2);
		System.out.println(ageSum);  // 76

		Integer ageSum2 = persons
				.stream()
				.reduce(0,
						(sum, p) -> {
							System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
							return sum += p.getAge();
						},
						(sum1, sum2) -> {
							System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
							return sum1 + sum2;
						});

		// accumulator: sum=0; person=Max
		// accumulator: sum=18; person=Peter
		// accumulator: sum=41; person=Pamela
		// accumulator: sum=64; person=David


		Integer ageSum3 = persons
				.parallelStream()
				.reduce(0,
						(sum, p) -> {
							System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
							return sum += p.getAge();
						},
						(sum1, sum2) -> {
							System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
							return sum1 + sum2;
						});

		// accumulator: sum=0; person=Pamela
		// accumulator: sum=0; person=David
		// accumulator: sum=0; person=Max
		// accumulator: sum=0; person=Peter
		// combiner: sum1=18; sum2=23
		// combiner: sum1=23; sum2=12
		// combiner: sum1=41; sum2=35
    }


}
