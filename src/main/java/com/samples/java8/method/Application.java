package com.samples.java8.method;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alakus on 12/2/2015.
 */
public class Application {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Veli", "Selami");
        Application app = new Application();
        names.forEach(Application::sayHello);
        names.forEach(app::sayBye);


        List<Integer> numbers = Arrays.asList(5, 10, 1, 5, 6);
        Collections.sort(numbers, Application::sort);
    }

    public static void sayHello(String name) {
        System.out.println("Hello " + name + " :) ");
    }

    public void sayBye(String name) {
        System.out.println("Bye " + name + " :( ");
    }

    public static Integer sort(Integer number1, Integer number2) {
        return number1 - number2;
    }
}
