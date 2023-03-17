package com.modernJava.lvl3_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
        // simple lambda
        Runnable runnable = () -> System.out.println("Hello there!");
        runnable.run();

        // Filtering with lambdas
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        //green Apples
        List<Apple> greenApples = filter(inventory, (Apple apple)-> apple.getColor() ==Color.GREEN);
        System.out.println(greenApples);

        // Comparator
        Comparator<Apple> comparator = (Apple apple1, Apple apple2) -> apple1.getWeight() - apple2.getWeight();
        inventory.sort(comparator);
        System.out.println(inventory);
    }
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
