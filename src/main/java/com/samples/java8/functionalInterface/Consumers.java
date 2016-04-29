package com.samples.java8.functionalInterface;

import java.util.function.Consumer;

/**
 * Created by alakus on 4/26/2016.
 */
public class Consumers {
	public static void main(String[] args) {
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));
	}
}
