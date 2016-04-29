package com.samples.java8.scope;

/**
 * Created by alakus on 4/26/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(testLocal());
        System.out.println(new Main().testInstanceAndSta());
    }

    private static String testLocal() {
        int num = 1;
        Converter<Integer, String> stringConverter =
            (from) -> String.valueOf(from + num);
        // num = 4;
        return stringConverter.convert(2); // 3
    }

    static int outerStaticNum;
    int        outerNum;

    private String testInstanceAndSta() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(outerNum + " " + from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(outerStaticNum + " " + from);
        };
        return stringConverter1.convert(2) + " ::: " + stringConverter2.convert(2);
    }

    @FunctionalInterface
    interface Converter<F, T> {

        T convert(F from);
    }
}
