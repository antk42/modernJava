package com.modernJava.lvl6_streamAPI;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Grouping {
    enum CaloricLevel { DIET, NORMAL, FAT };

    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
        System.out.println("Dish names grouped by type: " + groupDishNamesByType());
        System.out.println("Dish tags grouped by type: " + groupDishTagsByType());
        System.out.println("Caloric dishes grouped by type: " + groupCaloricDishesByType());
        System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel());
    }
    private static Map<Dish.Type, List<Dish>> groupDishesByType(){
        return Dish.menu.stream()
                .collect(groupingBy(Dish::getType));
    }
    private static Map<Dish.Type, List<String>> groupDishNamesByType(){
        return Dish.menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }
    private static Map<Dish.Type, Set<String>> groupDishTagsByType() {
        return Dish.menu.stream().collect(
                groupingBy(Dish::getType,
                        flatMapping(dish -> Dish.dishTags.get(dish.getName()).stream(), toSet())));
    }

    private static Map<Dish.Type, List<Dish>> groupCaloricDishesByType() {
        return Dish.menu.stream().collect(
                groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return Dish.menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    }
                    else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    }
                    else {
                        return CaloricLevel.FAT;
                    }
                })
        );
    }


}
