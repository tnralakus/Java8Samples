package com.samples.java8.stream;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alakus on 4/27/2016.
 */
public class Maps {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3); // val33

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9); // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23); // true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3); // val33

        map.forEach((k, v) -> System.out.println(k + " : " + v));

        map.remove(3, "val3");
        map.get(3); // val33
        map.remove(3, "val33");
        map.get(3); // null

        map.getOrDefault(42, "not found"); // not found

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9); // val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9); // val9concat
    }
}
