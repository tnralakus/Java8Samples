package com.samples.java8.defaultMethods;

/**
 * Created by Alakus on 12/2/2015.
 */
public interface Vehicle {
    void start();

    default void stop() {
        System.out.println("Vehicle :: STOP");
    }
}
