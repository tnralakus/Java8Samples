package com.samples.java8.functionalInterface;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by alakus on 4/26/2016.
 */
public class Predicates {
	public static void main(String[] args) {
		Predicate<String> predicate = (s) -> s.length() > 0;

		predicate.test("foo");              // true
		predicate.negate().test("foo");     // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
	}
}
