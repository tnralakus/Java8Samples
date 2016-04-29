package com.samples.java8.functionalInterface;

import java.util.function.Function;

/**
 * Created by alakus on 4/26/2016.
 */
public class Functions {
	public static void main(String[] args) {
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		backToString.apply("123");     // "123"
	}
}
