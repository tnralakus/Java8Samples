package com.samples.java8.defaultMethods;

/**
 * Created by Alakus on 12/2/2015.
 */
public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();

        Bus bus = new Bus();
        bus.start();
        bus.stop();
    }
}
