package com.modernJava.lvl5_streamAPI;

import com.modernJava.lvl4_streamAPI.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        // map
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "there!");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split(" ")))
                .distinct()
                .forEach(System.out::println);
    }
}
