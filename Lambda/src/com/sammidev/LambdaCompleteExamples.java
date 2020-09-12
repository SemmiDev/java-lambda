package com.sammidev;

import java.util.Arrays;
import java.util.function.*;

public class LambdaCompleteExamples {
    public static void main(String[] args) {

        // LAMBDA APP
        String text = "SAMMIDEV";

        Predicate<String> predicate = (value) -> value != null;
        System.out.println(predicate.test(text));
        System.out.println(predicate.test(""));
        System.out.println(predicate.test(null));

        Function<String, String> function = (value) -> value.toLowerCase();
        System.out.println(function.apply(text));

        Consumer<String> consumer = (value) -> System.out.println(value.toUpperCase());
        consumer.accept(text);
        consumer.accept("hello consumer");

        Supplier<String> supplier = () -> text;
        System.out.println(supplier.get());

        BiPredicate<String, String> biPredicate = (val1, val2) -> val1.toUpperCase().contains(val2);
        System.out.println(biPredicate.test(text, "DEV"));

        printLambda(() -> text);

        // LAMBDA METHOD APP
        Predicate<String> predicate1 = LambdaCompleteExamples::isNotNull;

        Predicate<String> predicate2 = String::isEmpty;
        BiPredicate<String, String> biPredicate1 = LambdaCompleteExamples::isEquals;

        Function<String, String> function1 = text::concat;
        Consumer<String> consumer1 = System.out::println;

        // LAMBDA INTERFACE APP
        ArgsConsumer<String> consumer2 = LambdaCompleteExamples::printAll;
        consumer2.consume("sam","dev","adit");

    }

    public static boolean isNotNull(String val) {
        return val != null;
    }
    public static boolean isEquals(String val1, String val2){
        return val1.equalsIgnoreCase(val2);
    }
    public static void printAll(String[] arguments){
        Arrays.stream(arguments).forEachOrdered(System.out::println);
    }
    public static void printLambda(Supplier<String> supplier){
        System.out.println(supplier.get());
    }

    @FunctionalInterface
    interface ArgsConsumer<T> {
        void consume(T ...arg);
    }
}