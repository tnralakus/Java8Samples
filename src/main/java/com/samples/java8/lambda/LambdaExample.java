package com.samples.java8.lambda;

/**
 * Created by Alakus on 12/1/2015.
 */
public class LambdaExample {
    public static void main(String[] args) {
        LambdaExample lambdaExample = new LambdaExample();
        int result = lambdaExample.calculate((a, b) -> a + b, 2, 3);
        System.out.println("Result : " + result);

    }

    public int calculate(Anonym anonym, int x, int y) {
        return anonym.apply(x, y);
    }
}
