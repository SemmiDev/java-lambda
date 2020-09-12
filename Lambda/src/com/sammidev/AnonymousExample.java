package com.sammidev;

import java.util.function.*;

public class AnonymousExample {

    public static void main(String[] args) {

        // PREDICATE
        Predicate<String> predicate = new Predicate<String>() {
            Boolean status = false;

            @Override
            public boolean test(String s) {
                if (s != null) {
                    return status = true;
                }
                return status;
            }

            @Override
            public String toString() {
                return "status -> " + status;
            }
        };
        predicate.test("sam");
        System.out.println(predicate.toString());

        // FUNCTION
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase() + s.replaceAll("Sammidev","sammi ganteng") + s.repeat(5);
            }
        };
        System.out.println(function.apply("Sammidev "));

        // CONSUMER
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("hello " + s);
            }
        };
        consumer.accept("sammidev");

        // SUPPLIER
        Supplier<String> supplier = new Supplier<String>() {

            @Override
            public String get() {
                return "sammidev";
            }
        };
        System.out.println(supplier.get());

        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.startsWith("sammi") && s2.endsWith("dev");
            }
        };
        System.out.println(biPredicate.test("sammi","dev"));
    }
}