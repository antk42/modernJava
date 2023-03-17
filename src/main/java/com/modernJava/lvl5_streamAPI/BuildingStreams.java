package com.modernJava.lvl5_streamAPI;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args) {
        // stream.of
        Stream<String> stream = Stream.of("hello", "stream", "API", "world");
        stream.map(String::toUpperCase).forEach(System.out::println);
        System.out.println("========");

        // stream.empty
        Stream<String> emptyStream = Stream.empty();
        System.out.println(emptyStream);
        System.out.println("========");

        // Arrays.stream
        int[] numbers = { 2, 3, 5, 7, 11, 13 };
        System.out.println(Arrays.stream(numbers).sum());
        System.out.println("========");


        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("========");

        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("========");
    }
}
