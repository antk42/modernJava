package com.modernJava.lvl2_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        // greenApples
        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        System.out.println(greenApples);

        // redApples
        List<Apple> redApples = filterApplesByColor(inventory,Color.RED);
        System.out.println(redApples);

        // greenApples 2 predicate
        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);

        // heavyApples
        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        // redAndHeavyApples
        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
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
