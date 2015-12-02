package com.samples.java8.lambda;

/**
 * Created by Alakus on 12/1/2015.
 */
public class BeforeLambdaExample {
    public static void main(String[] args) {
        BeforeLambdaExample beforeLambdaExample = new BeforeLambdaExample();
        int result = beforeLambdaExample.func(2, 3, new Anonym() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        });
        System.out.println("Result : " + result);
    }

    public int func(int a, int b, Anonym anonym) {
        return anonym.apply(a, b) * 2;
    }
}
