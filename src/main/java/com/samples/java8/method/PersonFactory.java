package com.samples.java8.method;

interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);
}