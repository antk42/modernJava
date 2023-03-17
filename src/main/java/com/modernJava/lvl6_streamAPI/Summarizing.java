package com.modernJava.lvl6_streamAPI;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Summarizing {
    public static void main(String[] args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
        System.out.println("Short menu: " + getShortMenu());
    }
    private static long howManyDishes(){
        return Dish.menu.stream().collect(counting());
    }

    private static Dish findMostCaloricDish(){
        return Dish.menu.stream()
                .collect(Collectors.reducing((dish1, dish2) -> dish1.getCalories() > dish2.getCalories() ? dish1 : dish2))
                .get();
    }
    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return Dish.menu.stream().collect(averagingInt(Dish::getCalories));
    }


    private static String getShortMenu() {
        return Dish.menu.stream().map(Dish::getName).collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return Dish.menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
