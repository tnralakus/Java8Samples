package com.samples.java8.annotation;

import java.lang.annotation.Repeatable;

/**
 * Created by alakus on 4/27/2016.
 */
public class Annotations {
	public static void main(String[] args) {
		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint);                   // null

		Hints hints1 = Person.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2

		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);
	}

	//@Hints({@Hint("hint1"), @Hint("hint2")})
	@Hint("hint1")
	@Hint("hint2")
	class Person {}

	//@Target({ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
	@interface Hints {
		Hint[] value();
	}

	//@Target({ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
	@Repeatable(Hints.class)
	@interface Hint {
		String value();
	}
}
