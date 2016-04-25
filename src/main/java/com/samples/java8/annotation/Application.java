package com.samples.java8.annotation;

/**
 * Created by Alakus on 12/2/2015.
 */
@Single("Type")
public class Application {

    @Single("Field")
    String message = "Hello World!!!";

    @Single("Method")
    public void doIt() {

    }

	@Single("first")
	@Single("second")
    public void multipleExample() {

    }

    public static void main(String[] args) {
        Class<Application> app = Application.class;
        Single[] annotationsByType = app.getAnnotationsByType(Single.class);
        for (Single ann : annotationsByType) {
            System.out.println(ann.value());
        }
    }
}
