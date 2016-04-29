package com.samples.java8.optional;

import java.util.Optional;

/**
 * Created by alakus on 4/26/2016.
 */
public class Optionals {
	public static void main(String[] args) {
		Optional<String> optional = Optional.of("bam");

		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	}
}
