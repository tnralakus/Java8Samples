package com.samples.java8.defaultMethods;

/**
 * Created by Alakus on 12/2/2015.
 */
public class Bus implements Engine, Vehicle {
    @Override
    public void start() {
        System.out.println("Bus :: START");
    }

    @Override
    public void stop() {
        Vehicle.super.stop();
    }
}
