package com.samples.java8.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Alakus on 12/2/2015.
 */
public class Application {
    public static void main(String[] args) {
        Optional<Double> empty = Optional.empty();
        Optional<String> of = Optional.of("Hello World");
        Optional<String> ofNull = Optional.of("");
        Optional<Integer> ofNullable = Optional.ofNullable(null);

        Integer number = null;
        Optional<Integer> opt = Optional.ofNullable(number);
        opt.ifPresent(num -> {
            Double square = Math.pow(num, 2);
            System.out.println(square);
        });

        opt.map(num -> Math.pow(num, 2)).ifPresent(System.out::println);

        int result = opt.orElse(1);
        System.out.println(result);

        String message = null;
        Optional<String> optMessage = Optional.ofNullable(message);
        optMessage.filter(m -> m.length() > 5).ifPresent(System.out::println);

        List<String> names = Arrays.asList("Ali", "Veli", "Selami");
        Optional<List<String>> optList = Optional.ofNullable(names);
        names = optList.orElseGet(() -> new ArrayList());
        names = optList.orElseGet(ArrayList::new);

        optList.orElseThrow(RuntimeException::new);
    }
}