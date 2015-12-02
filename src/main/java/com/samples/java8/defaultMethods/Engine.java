package com.samples.java8.defaultMethods;

/**
 * Created by Alakus on 12/2/2015.
 */
public interface Engine {
    void start();
    default void stop(){
        System.out.println("Engine :: STOP");
    }
}
