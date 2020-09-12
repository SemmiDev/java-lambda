package com.sammidev;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        Stream<String> newStream = Stream.of("SammIDEV","AdItya", "AyatULLAH");
        List<String> newList = Arrays.asList("cat","dog","camel", "dug");

        newList.stream()
                .filter(val -> !val.isEmpty()
                        && !val.isBlank()
                        && val.contains("o")
                        && val.startsWith("d")
                        && val.endsWith("g"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        newStream.map(String::toLowerCase)
                .forEach(System.out::println);
    }
}