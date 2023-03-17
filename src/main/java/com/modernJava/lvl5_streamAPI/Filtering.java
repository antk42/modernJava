package com.modernJava.lvl5_streamAPI;

import com.modernJava.lvl4_streamAPI.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        // Filtering with predicate
        System.out.println("Filtering with a predicate");
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        System.out.println("Filtering unique elements:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 3);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
