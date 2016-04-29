package com.samples.java8.method;

/**
 * Created by alakus on 4/26/2016.
 */
public class PersonMain {

    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
		System.out.println(person.firstName + " " + person.lastName);
	}
}
