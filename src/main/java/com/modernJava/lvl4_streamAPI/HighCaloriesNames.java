package com.modernJava.lvl4_streamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class HighCaloriesNames {
    public static void main(String[] args) {
        List<String> names = Dish.menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories() > 450;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(8)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
