package com.samples.java8.annotation;

/**
 * Created by Alakus on 12/2/2015.
 */
public class BeforeJava8Example {
    @Multiple({@Single("First"), @Single("Second")})
    public void doIt() {

    }
}
