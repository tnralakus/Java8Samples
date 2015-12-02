package com.samples.java8.annotation;

import java.lang.annotation.*;

/**
 * Created by Alakus on 12/2/2015.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Multiple.class)
public @interface Single {
    String value();
}
