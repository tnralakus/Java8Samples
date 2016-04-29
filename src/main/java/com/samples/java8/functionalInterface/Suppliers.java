package com.samples.java8.functionalInterface;

import java.util.function.Supplier;

import com.samples.java8.stream.Person;

/**
 * Created by alakus on 4/26/2016.
 */
public class Suppliers {
	public static void main(String[] args) {
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person
	}
}
