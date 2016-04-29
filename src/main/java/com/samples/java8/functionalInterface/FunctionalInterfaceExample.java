package com.samples.java8.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Created by Alakus on 12/1/2015.
 */
public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        // CONSUMER
        //Consumer<String> consumer = (String s) -> {
        //    System.out.println(s);
        //};
        Consumer<String> consumer = a -> System.out.println(a);
        consumer.accept("Hello");


        List<String> names = Arrays.asList("Taner", "Secil", "Alakus");
        names.forEach(consumer);

        names.forEach(ListApplication::list);

        // BICONSUMER
        //BiConsumer<String, Integer> biConsumer = (name, age) -> {
        //  System.out.println(name + ":" + age);
        //};
        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name + " is " + age + " years old.");
        biConsumer.accept("Taner", 25);

        //FUNCTION
        Function<Integer, Double> function = t -> Math.pow(t, 2);
        System.out.println(function.apply(5));

        //UNARYOPERATOR
        UnaryOperator<Integer> unaryOperator = i -> i * i;
        System.out.println(unaryOperator.apply(4));

        //BIFUNCTION
        BiFunction<Integer, Integer, String> biFunction = (a, b) -> "Result : " + (a + b);
        System.out.println(biFunction.apply(6, 2)); // Sonuç: 8

        //BINARYOPERATOR
        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        System.out.println(binaryOperator.apply(3, 5));

        //PREDICATE
        Predicate<Integer> predicate = a -> (a > 0);
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(-1));

        //BIPREDICATE
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a > b);
        System.out.println(biPredicate.test(5, 4));
        System.out.println(biPredicate.test(5, 6));

        //SUPPLIER
        Supplier<List> supplier = () -> new ArrayList<>();
        List<String> list = supplier.get();
        list.add("Ali");
        list.add("Veli");
        list.add("Selami");

        List nameList = new ArrayList();
        nameList.add("David");
        nameList.add("Sam");
        nameList.add("Ben");

        nameList.stream().forEach((x) -> {
            printNames(() -> x);
        });


		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);

    }

    public static void printNames(Supplier arg) {
        System.out.println(arg.get());
    }
}

@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);

	default String myDefault(){
		return "myDefault";
	}
}

class ListApplication {
    public static void list(String text) {
        System.out.println(text);
    }
}